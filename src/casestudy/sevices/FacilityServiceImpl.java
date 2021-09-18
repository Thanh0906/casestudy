package casestudy.sevices;


import casestudy.model.facility.Facility;
import casestudy.model.facility.House;
import casestudy.model.facility.Room;
import casestudy.model.facility.Villa;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    //hiển thị danh sách facility, thêm mới facility, hiển thị danh sách facility cần bảo trì.
        static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static Set<Facility> keySet = facilityIntegerMap.keySet();

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addList() {
        System.out.println("What do you want?");
        System.out.println("1. Add new Villa");
        System.out.println("2. Add new House");
        System.out.println("3. Add new Room");
        System.out.println("4. Back to menu");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                break;
            default:
                System.out.println("Error!!!");
        }
    }

    @Override
    public void displayList() {
        List<String> listFacility = ReadAndWrite.readCSV("src\\casestudy\\data\\facility\\facilityMaintenance.csv");
        for (int i = 0; i < listFacility.size(); i++) {
            System.out.println(listFacility.get(i));
        }
        List<House> houses = ReadAndWrite.getListHouseFromCSV("src\\casestudy\\data\\facility\\house.csv");
        List<Room> rooms = ReadAndWrite.getListRoomFromCSV("src\\casestudy\\data\\facility\\room.csv");
        List<Villa> villas = ReadAndWrite.getListVilllaFromCSV("src\\casestudy\\data\\facility\\villa.csv");
        System.out.println("List Houses: ");
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(i + 1 + ". " + houses.get(i));
        }
        System.out.println("List Rooms: ");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(i + 1 + ". " + rooms.get(i));
        }
        System.out.println("List Villas: ");
        for (int i = 0; i < villas.size(); i++) {
            System.out.println(i + 1 + ". " + villas.get(i));
        }
        System.out.println("All List");

    }

    @Override
    public void editList() {
    }

    public void addNewVilla() {

        try {
            String idService = getIdService(facilityIntegerMap);
            String nameService;
            do {
                System.out.println("Enter name of service:");
                nameService = scanner.nextLine();
            }
            while (!Validation.validateNameService(nameService));

            double useArea;
            do {
                System.out.println("Enter area of villa (m2):");
                useArea = Double.parseDouble(scanner.nextLine());
            }
            while (!Validation.validateArea(useArea));
            int rentalCosts;
            do {
                System.out.println("Enter cost of villa($): ");
                rentalCosts = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateCost(rentalCosts));
            int numberPeople;
            do {
                System.out.println("Enter the number of people of villa: ");
                numberPeople = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateNumberPeople(numberPeople));
            String styleRental;
            do {
                styleRental = chooseRentalType();
            }
            while (!Validation.validateRentalType(styleRental));
            String roomStandard;
            do {
                System.out.println("Enter room standard of villa:");
                roomStandard = scanner.nextLine();
            }
            while (!Validation.validateRoomStandard(roomStandard));
            double poolArea;
            do {
                System.out.println("Enter area of pool(m2):");
                poolArea = Double.parseDouble(scanner.nextLine());
            }
            while (!Validation.validatePoolArea(poolArea));
            int numberFloors;
            do {
                System.out.println("Enter the number of floors of villa:");
                numberFloors = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateNumberFloor(numberFloors));
            Villa villa = new Villa(idService, nameService, useArea, rentalCosts, numberPeople,
                    styleRental, roomStandard, poolArea, numberFloors);
            List<Villa> villaList = new ArrayList<>();
            villaList.add(villa);
            ReadAndWrite.writeListVillaCSV(villaList, "src\\casestudy\\data\\facility\\villa.csv", false);
            facilityIntegerMap.put(villa, 0);
            ReadAndWrite.writeListFacilituCSV(facilityIntegerMap, "src\\casestudy\\data\\facility\\facilityMaintenance.csv", false);
            System.out.println("New more success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewHouse() {
        try {
            String idService = getIdService(facilityIntegerMap);

            String nameService;
            do {
                System.out.println("Enter name of service:");
                nameService = scanner.nextLine();
            }
            while (!Validation.validateNameService(nameService));

            double useArea;
            do {
                System.out.println("Enter area of villa (m2):");
                useArea = Double.parseDouble(scanner.nextLine());
            }
            while (!Validation.validateArea(useArea));
            int rentalCosts;
            do {
                System.out.println("Enter cost of villa($): ");
                rentalCosts = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateCost(rentalCosts));
            int numberPeople;
            do {
                System.out.println("Enter the number of people of villa: ");
                numberPeople = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateNumberPeople(numberPeople));
            String styleRental;
            do {
                styleRental = chooseRentalType();
            }
            while (!Validation.validateRentalType(styleRental));
            String roomStandard;
            do {
                System.out.println("Enter room standard of villa:");
                roomStandard = scanner.nextLine();
            }
            while (!Validation.validateRoomStandard(roomStandard));
            int numberFloors;
            do {
                System.out.println("Enter the number of floors of villa:");
                numberFloors = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateNumberFloor(numberFloors));
            House house = new House(idService, nameService, useArea, rentalCosts, numberPeople, styleRental, roomStandard, numberFloors);
            List<House> houses = new ArrayList<>();
            houses.add(house);
            ReadAndWrite.writeListHouseCSV(houses, "src\\casestudy\\data\\facility\\house.csv", false);
            facilityIntegerMap.put(house, 0);
            ReadAndWrite.writeListFacilituCSV(facilityIntegerMap, "src\\casestudy\\data\\facility\\facilityMaintenance.csv", false);
            System.out.println("New more success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewRoom() {
        try {

            String idService = getIdService(facilityIntegerMap);

            String nameService;
            do {
                System.out.println("Enter name of service:");
                nameService = scanner.nextLine();
            }
            while (!Validation.validateNameService(nameService));

            double useArea;
            do {
                System.out.println("Enter area of villa (m2):");
                useArea = Double.parseDouble(scanner.nextLine());
            }
            while (!Validation.validateArea(useArea));
            int rentalCosts;
            do {
                System.out.println("Enter cost of villa($): ");
                rentalCosts = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateCost(rentalCosts));
            int numberPeople;
            do {
                System.out.println("Enter the number of people of villa: ");
                numberPeople = Integer.parseInt(scanner.nextLine());
            }
            while (!Validation.validateNumberPeople(numberPeople));
            String styleRental;
            do {
                styleRental = chooseRentalType();
            }
            while (!Validation.validateRentalType(styleRental));
            System.out.println("Enter FreeService");
            String freeService = scanner.nextLine();
            Room room = new Room(idService, nameService, useArea, rentalCosts, numberPeople, styleRental, freeService);
            facilityIntegerMap.put(room, 0);
            List<Room> rooms = new ArrayList<>();
            rooms.add(room);
            ReadAndWrite.writeListRoomCSV(rooms, "src\\casestudy\\data\\facility\\room.csv", false);
            ReadAndWrite.writeListFacilituCSV(facilityIntegerMap, "src\\casestudy\\data\\facility\\facilityMaintenance.csv", false);
            System.out.println("New more success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayListForMaintenance() {
        List<String> listFacility = ReadAndWrite.readCSV("src\\casestudy\\data\\facility\\facilityMaintenance.csv");
        System.out.println("List Facility Maintenance: ");
        for (int i = 0; i < listFacility.size(); i++) {
            String[] string = listFacility.get(i).split(",");
            if (Integer.parseInt(string[2]) > 5) {
                System.out.println(i + 1 + ". " + listFacility.get(i));
            }

        }
    }

    private String chooseRentalType() {
        String rentalType;
        System.out.println("Choose rental type: "
                + "1.Year \n"
                + "2.Month \n"
                + "3.Day \n"
                + "4.Hour "
        );
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                rentalType = "Year";
                break;
            case "2":
                rentalType = "Month";
                break;
            case "3":
                rentalType = "Day";
                break;
            case "4":
                rentalType = "Hour";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        return rentalType;
    }

    private String getIdService(Map<Facility, Integer> map) {
        Set<Facility> keySet = map.keySet();
        String idService = "";
        boolean flag = true;
        while (flag) {
            try {
                do {
                    System.out.println("Enter new id service(SVXX-YYYY)");
                    idService = scanner.nextLine();
                }
                while (!Validation.validateCodeService(idService));
            } catch (Exception e) {
                e.printStackTrace();
            }
            flag = false;
            for (Facility key : keySet) {
                if (key.getIdService().equals(idService)) {
                    System.out.println("Id service is exist, please enter again !");
                    flag = true;
                    break;
                }
            }
        }
        return idService;
    }

}
