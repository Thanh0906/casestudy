package casestudy.utils;

import casestudy.model.Booking;
import casestudy.model.Contract;
import casestudy.model.facility.Facility;
import casestudy.model.facility.House;
import casestudy.model.facility.Room;
import casestudy.model.facility.Villa;
import casestudy.model.person.Customer;
import casestudy.model.person.Employee;

import java.io.*;
import java.util.*;


public class ReadAndWrite {

    public static void writeListStringToCSV( List<String> string, String path, boolean append){
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line: string){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writer file");

        }
    }
    public static void writeListEmployeeCSV(List<Employee> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Employee employee : list){
            stringList.add(employee.getToString());
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static void writeListCustomerCSV(List<Customer> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Customer cusList : list){
            stringList.add(cusList.getToSTring());
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static void writeListHouseCSV(List<House> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (House house : list){
            stringList.add(house.getToString());
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static void writeListRoomCSV(List<Room> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Room room : list){
            stringList.add(room.getToString());
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static void writeListVillaCSV(List<Villa> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Villa villa : list){
            stringList.add(villa.getToString());
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static void writeListFacilituCSV(Map<Facility,Integer> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Facility facility : list.keySet()){
           String key = facility.getToString();
            stringList.add(key);
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static  void writeListBookingCSV(Set<Booking> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Booking booking : list){
            stringList.add(booking.getToString());
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static void writeQueueBookingCSV(Queue<Booking> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Booking booking : list){
            stringList.add(booking.getToString());
        }
        writeListStringToCSV(stringList,path,append);
    }
    public static void writeListContractCSV(List<Contract> list, String path, boolean append){
        List<String> stringList =new ArrayList<>();
        for (Contract contract : list){
            stringList.add(contract.getToString());
        }
        writeListStringToCSV(stringList,path,append);
    }

    public static List<String> readCSV(String path){
        File file = new File(path);
        List<String> listString = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                listString.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reader file");
        }
        return listString;
    }
    public static Map<Facility,Integer> getFacilityMap(String path){
        List<String> listString = readCSV(path);
        Map<Facility,Integer> facilityMap = new LinkedHashMap<>();
        for (String s : listString) {
            String[] array = s.split(",");
            if (array[0].equals("Villa")) {
                Facility villa = new Villa(array[1], array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]), array[6], array[7],
                        Double.parseDouble(array[8]), Integer.parseInt(array[9]));
                facilityMap.put(villa, Integer.parseInt(array[10]));
            }
            if (array[0].equals("House")) {
                Facility house = new House(array[1], array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]), array[6], array[7],
                        Integer.parseInt(array[8]));
                facilityMap.put(house, Integer.parseInt(array[9]));
            }
            if (array[0].equals("Room")) {
                Facility room = new Room(array[1], array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]), array[6], array[7]);
                facilityMap.put(room, Integer.parseInt(array[8]));
            }
        }
        return facilityMap;
    }

    public static List<Employee> getListEmployeeFromCSV(String path){
        List<Employee> employees =new ArrayList<>();
        List<String> stringList =readCSV(path);
        for (String line : stringList){
            String[] array = line.split(",");
            Employee employee = new Employee(array[0],array[1],array[2],array[3],(array[4]),
                    (array[5]),array[6],array[7],Double.parseDouble(array[8]));
            employees.add(employee);
        }
        return employees;
    }
    public static List<Customer> getListCustomerFromCSV(String path){
        List<Customer> customers =new ArrayList<>();
        List<String> stringList =readCSV(path);
        for (String line : stringList){
            String[] array = line.split(",");
            Customer customer = new Customer(array[0],array[1],array[2],array[3],
                    array[4],array[5],array[6],array[7],array[8]);
            customers.add(customer);
        }
        return customers;
    }
    public static List<House> getListHouseFromCSV(String path) {
        List<House> houses = new ArrayList<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            House house = new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]),
                    Integer.parseInt(array[4]), array[5], array[6], Integer.parseInt(array[7]));
            houses.add(house);
        }
        return houses;
    }
    public static List<Room> getListRoomFromCSV(String path) {
        List<Room> rooms = new ArrayList<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            Room room = new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]),
                    Integer.parseInt(array[4]), array[5], array[6]);
            rooms.add(room);
        }
        return rooms;
    }
    public static List<Villa> getListVilllaFromCSV(String path) {
        List<Villa> villas = new ArrayList<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            Villa villa = new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]),
                    Integer.parseInt(array[4]), array[5], array[6],Double.parseDouble(array[7]),Integer.parseInt(array[8]));
            villas.add(villa);
        }
        return villas;
    }
    public static Set<Booking> getListBookingFromCSV(String path) {
        Set<Booking> bookings = new TreeSet<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            Booking booking = new Booking(array[0], array[1], array[2], array[3], array[4], array[5]);
            bookings.add(booking);
        }
        return bookings;
    }
    public static Queue<Booking> getQueueBookingFromCSV(String path) {
        Queue<Booking> bookings = new LinkedList<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            Booking booking = new Booking(array[0], array[1], array[2], array[3], array[4], array[5]);
            bookings.add(booking);
        }
        return bookings;
    }
    public static List<Contract> getListContractFromCSV(String path) {
        List<Contract> contracts = new ArrayList<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            Contract contract = new Contract(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), array[4]);
            contracts.add(contract);
        }
        return contracts;
    }


}
