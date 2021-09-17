package casestudy.sevices;

import casestudy.model.Booking;
import casestudy.model.Contract;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> listBooking = new TreeSet<>();
    static Queue<Booking> queueBooking = new LinkedList<>();


    @Override
    public void addList() {
        System.out.println("Enter idBokking");
        String idBooking = scanner.nextLine();
        System.out.println("Enter stardate(dd/mm/yyyy)");
        String startDate = Validation.inputDay();
        System.out.println("Enter enddate(dd/mm/yyyy)");
        String endDate = Validation.inputDay();
        System.out.println("Enter idCustomer");
        String idCustomer = scanner.nextLine();
        System.out.println("Enter nameService");
        String nameService = Validation.inputNameService();
        System.out.println("Enter idService");
        String idService = scanner.nextLine();
        Booking booking = new Booking(idBooking,startDate,endDate,idCustomer,nameService,idService);
        listBooking =ReadAndWrite.getListBookingFromCSV("src\\casestudy\\data\\listBooking.csv");
        listBooking.add(booking);
        ReadAndWrite.writeListBookingCSV(listBooking,"src\\casestudy\\data\\listBooking.csv",false);
        System.out.println("Thêm thành công");
        //
        List<Contract> listContract = ReadAndWrite.getListContractFromCSV("src\\casestudy\\data\\contract.csv");
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
        listBooking = ReadAndWrite.getListBookingFromCSV("src\\casestudy\\data\\listBooking.csv");
        System.out.println("List booking: ");
        for (Booking booking : listBooking) {
            System.out.println(booking.toString());
        }

    }

    @Override
    public void editList() {

    }

}
