package casestudy.sevices;

import casestudy.model.Booking;
import casestudy.model.Contract;
import casestudy.model.facility.Facility;
import casestudy.model.facility.House;
import casestudy.model.facility.Room;
import casestudy.model.facility.Villa;
import casestudy.model.person.Customer;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.util.*;
import java.util.concurrent.Callable;

public class BookingServiceImpl implements IBookingService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> listBooking = new TreeSet<>();
    static Queue<Booking> queueBooking = new LinkedList<>();
    static final String HOUSE_PATH = "src\\casestudy\\data\\facility\\house.csv";
    static final String VILLA_PATH = "src\\casestudy\\data\\facility\\villa.csv";
    static final String ROOM_PATH = "src\\casestudy\\data\\facility\\room.csv";
    static final String LISTBOOKING_PATH = "src\\casestudy\\data\\listBooking.csv";
    static final String CONTRACT_PATH = "src\\casestudy\\data\\contract.csv";


    @Override
    public void addList() {
        String idBooking = "";
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Enter idBokking");
                idBooking = scanner.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            flag = false;
            for (Booking booking : listBooking) {
                if (booking.getIdBooking().equals(idBooking)) {
                    System.out.println("IDBooking is exist, please enter again !");
                    flag = true;
                    break;
                }
            }
        }
        System.out.println("Enter stardate(dd/mm/yyyy)");
        String startDate = Validation.inputDay();
        System.out.println("Enter enddate(dd/mm/yyyy)");
        String endDate = Validation.inputDay();
        String idCustomer = getIdCustomer();
        System.out.println("EnternameService");
        String nameService = getNameService();
        System.out.println("Enter idService");
        String idService = getIdService();
        Booking booking = new Booking(idBooking, startDate, endDate, idCustomer, nameService, idService);
        listBooking = ReadAndWrite.getListBookingFromCSV(LISTBOOKING_PATH);
        listBooking.add(booking);
        ReadAndWrite.writeListBookingCSV(listBooking, LISTBOOKING_PATH, false);
        System.out.println("Thêm thành công");
        //
        List<Contract> listContract = ReadAndWrite.getListContractFromCSV(CONTRACT_PATH);
        Queue<Booking> queueBooking = new LinkedList<>();
        for (Booking listBooking1 : listBooking) {
            int count = 0;
            for (int i = 0; i < listContract.size(); i++) {
                if (listContract.get(i).getIdBooking().equals(listBooking1.getIdBooking())) {
                    count++;
                }
            }
            if (count == 0) {
                queueBooking.add(listBooking1);
            }

        }
        ReadAndWrite.writeQueueBookingCSV(queueBooking, "src\\casestudy\\data\\queueBooking.csv", false);
    }

    @Override
    public void displayList() {
        listBooking = ReadAndWrite.getListBookingFromCSV(LISTBOOKING_PATH);
        System.out.println("List booking: ");
        for (Booking booking : listBooking) {
            System.out.println(booking.getToString());
        }

    }

    @Override
    public void editList() {

    }

    public String getIdCustomer() {
        List<Customer> customerList = ReadAndWrite.getListCustomerFromCSV("src\\casestudy\\data\\customer.csv");
        System.out.println("idCustomer :");
        for (Customer customer:customerList){
            System.out.println(customer.getFullName()+ " ," +customer.getIdCustomer());
        }
        String IdCustomer = "";
        boolean checkIdCustomer = true;
        while (checkIdCustomer) {
            System.out.println("Enter IdCustomer");
            IdCustomer = scanner.nextLine();
            for (Customer customer : customerList) {
                if (customer.getIdCustomer().equals(IdCustomer)) {
                    checkIdCustomer = false;
                    break;
                }
            }
            if (checkIdCustomer) {
                System.out.println("Re-Enter");
            }
        }
        return IdCustomer;
    }

    public String getNameService() {
        List<Villa> villas = ReadAndWrite.getListVilllaFromCSV(VILLA_PATH);
        List<House> houses = ReadAndWrite.getListHouseFromCSV(HOUSE_PATH);
        List<Room> rooms = ReadAndWrite.getListRoomFromCSV(ROOM_PATH);
        List<String> arrayList = new ArrayList<>();
        System.out.println("ListVilla's nameService: ");
        for (Villa villa : villas) {
            System.out.println(villa.getNameService());
            arrayList.add(villa.getNameService());
        }
        System.out.println("ListHouse's nameService: ");
        for (House house : houses) {
            System.out.println(house.getNameService());
            arrayList.add(house.getNameService());
        }
        System.out.println("ListRoom's nameService: ");
        for (Room room : rooms) {
            System.out.println(room.getNameService());
            arrayList.add(room.getNameService());
        }

        boolean check = true;
        String nameService = "";
        while (check) {
            System.out.println("Enter nameService: ");
            nameService = scanner.nextLine();
            for (String string : arrayList) {
                if (string.equals(nameService)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("Cannot Find.Re-Enter");
            }
        }
        return nameService;
    }

    public String getIdService() {
        System.out.println("Choose idservice: 1.Villa /2.House / 3.Room ");
        String idService = "";
        int choose = Validation.inputNumber();
        switch (choose) {
            case 1:
                idService = "Villa";
                break;
            case 2:
                idService = "House";
                break;
            case 3:
                idService = "Room";
                break;
            default:
                System.out.println("Re-Enter");
        }
        return idService;
    }


}

