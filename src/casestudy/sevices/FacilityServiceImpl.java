package casestudy.sevices;


import casestudy.model.facility.Facility;
import casestudy.model.facility.House;
import casestudy.model.facility.Room;
import casestudy.model.facility.Villa;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.io.*;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    //hiển thị danh sách facility, thêm mới facility, hiển thị danh sách facility cần bảo trì.
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
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
            switch (choice){
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

    }

    @Override
    public void editList() {

    }

    public void addNewVilla() {
        try {
           Set<Facility> keySet = facilityIntegerMap.keySet();
            String idService = "";
            boolean flag = true;
            while (flag) {
                System.out.println("Enter  id service SVVL-xxxx");
                idService = Validation.inputIdService("VL");
                flag = false;
                for (Facility key : keySet) {
                    if (key.getIdService().equals(idService)) {
                        System.out.println("Id service is exist, please enter again !");
                        flag = true;
                        break;
                    }
                }
            }
            System.out.println("Enter nameService");
            String nameService = Validation.inputNameService();
            System.out.println("Enter useArea");
            double useArea = Validation.inputUseArea();
            System.out.println("Enter rentalCosts");
            double rentalCosts = Validation.inputDouble();
            System.out.println("Enter numberPeople");
            int numberPeople = Validation.inputNumberPeople();
            System.out.println("Enter styleRental");
            String styleRental = Validation.styleRental();
            System.out.println("Enter roomStandard");
            String roomStandard = scanner.nextLine();
            System.out.println("Enter poolArea");
            double poolArea = Validation.inputUseArea();
            System.out.println("Enter numberFloors");
            int numberFloors =Validation.inputNumberFloors();
            Villa villa = new Villa(idService,nameService,useArea,rentalCosts,numberPeople,
                    styleRental,roomStandard,poolArea,numberFloors);
            List<Villa> villaList = new ArrayList<>();
            villaList.add(villa);
            ReadAndWrite.writeListVillaCSV( villaList ,"src\\casestudy\\data\\facility\\villa.csv",true);
            facilityIntegerMap.put(villa,0);
            ReadAndWrite.writeListFacilituCSV(facilityIntegerMap,"src\\casestudy\\data\\facility\\facilityMaintenance.csv",true);
            System.out.println("New more success");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void addNewHouse() {
        try {
            Set<Facility> keySet = facilityIntegerMap.keySet();
            String idService = "";
            boolean flag = true;
            while (flag) {
                System.out.println("Enter  id service SVHO-xxxx");
                idService = Validation.inputIdService("HO");
                flag = false;
                for (Facility key : keySet) {
                    if (key.getIdService().equals(idService)) {
                        System.out.println("Id service is exist, please enter again !");
                        flag = true;
                        break;
                    }
                }
            }
            System.out.println("Enter nameService");
            String nameService = Validation.inputNameService();
            System.out.println("Enter useArea m2");
            double useArea = Validation.inputUseArea();
            System.out.println("Enter rentalCosts");
            double rentalCosts = Validation.inputDouble();
            System.out.println("Enter numberPeople");
            int numberPeople = Validation.inputNumberPeople();
            System.out.println("Enter styleRental");
            String styleRental = Validation.styleRental();
            System.out.println("Enter roomStandard");
            String roomStandard = scanner.nextLine();
            System.out.println("Enter numberFloors");
            int numberFloors =Validation.inputNumberFloors();
            House house = new House(idService,nameService,useArea,rentalCosts,numberPeople,styleRental,roomStandard,numberFloors);
            List<House> houses = new ArrayList< >();
            houses.add(house);
            ReadAndWrite.writeListHouseCSV(houses,"src\\src\\casestudy\\data\\facility\\house.csv",true);
            facilityIntegerMap.put(house, 0);
            ReadAndWrite.writeListFacilituCSV(facilityIntegerMap,"src\\casestudy\\data\\facility\\facilityMaintenance.csv",true);
            System.out.println("New more success");
            } catch (Exception e) {
            e.printStackTrace();
        }

        }

    public void addNewRoom() {
        try {
            Set<Facility> keySet = facilityIntegerMap.keySet();
            String idService = "";
            boolean flag = true;
            while (flag) {
                System.out.println("Enter  id service SVRO-xxxx");
                idService = Validation.inputIdService("RO");
                flag = false;
                for (Facility key : keySet) {
                    if (key.getIdService().equals(idService)) {
                        System.out.println("Id service is exist, please enter again !");
                        flag = true;
                        break;
                    }
                }
            }
            System.out.println("Enter nameService");
            String nameService = Validation.inputNameService();
            System.out.println("Enter useArea");
            double useArea = Validation.inputUseArea();
            System.out.println("Enter rentalCosts");
            double rentalCosts = Validation.inputDouble();
            System.out.println("Enter numberPeople");
            int numberPeople = Validation.inputNumberPeople();
            System.out.println("Enter styleRental");
            String styleRental = Validation.styleRental();
            System.out.println("Enter FreeService");
            String freeService = scanner.nextLine();
            Room room = new Room(idService,nameService,useArea,rentalCosts,numberPeople,styleRental,freeService);
            facilityIntegerMap.put(room, 0);
            List<Room> rooms = new ArrayList<>();
            rooms.add(room);
            ReadAndWrite.writeListRoomCSV(rooms,"src\\casestudy\\data\\facility\\room.csv",true);
            ReadAndWrite.writeListFacilituCSV(facilityIntegerMap,"src\\casestudy\\data\\facility\\facilityMaintenance.csv",true);
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
            if(Integer.parseInt(string[2]) >5){
                System.out.println(i + 1 + ". " + listFacility.get(i));
            }

        }
    }

}
