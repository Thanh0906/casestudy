package casestudy.sevices;

import casestudy.model.Booking;
import casestudy.model.person.Customer;
import casestudy.model.Booking;
import casestudy.model.person.Customer;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.time.LocalDate;
import java.util.*;

public class PromotionServiceImpl implements IPromotionService {

    static Scanner scanner = new Scanner(System.in);
    static List<Customer> arrayListCustomer = new ArrayList<>();
    static Stack<Booking> stackBooking = new Stack<>();
    static String year;

    @Override
    public void addList() {

    }

    @Override
    public void displayList() {
        try {
            Set<Booking> listBooking = ReadAndWrite.getListBookingFromCSV("src\\data\\ListBooking.csv");
            List<Customer> customers = ReadAndWrite.getListCustomerFromCSV("src\\data\\Customers.csv");
            System.out.println("Enter year: ");
            boolean boole = true;
            while (boole) {
                year = scanner.nextLine();
                int count = 0;
                for (Booking booking : listBooking) {
                    String[] strings = booking.getStartDate().split("/");
                    if (year.equals(strings[2])) {
                        for (Customer customer : customers) {
                            if (booking.getIdCustomer().equals(customer.getIdCustomer())) {
                                arrayListCustomer.add(customer);
                                count++;
                                break;
                            }
                        }

                    }
                }
                if (count == 0) {
                    System.out.println("Not found   Enter year again: ");

                } else {
                    boole = false;
                }

                for (Customer customer : arrayListCustomer) {
                    System.out.println(customer);
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    } public void displayPromotion() {
        try {
            Set<Booking> listBooking = ReadAndWrite.getListBookingFromCSV("casestudy\\data\\listBooking.csv");

               System.out.println("Enter voucher 10% quantity :");
               int voucher10 = Validation.inputNumber();
               System.out.println("Enter voucher 20% quantity :");
               int voucher20 = Validation.inputNumber();
               System.out.println("Enter voucher 50% quantity :");
               int voucher50 = Validation.inputNumber();

            int totalVoucher = voucher10 + voucher20 + voucher50;
            int count = 0;
            for (Booking booking : listBooking) {
                String[] string = booking.getStartDate().split("/");
                LocalDate today = LocalDate.now();
                int month = today.getMonthValue();
                System.out.println(year.equals(string[2]));
                if (Integer.parseInt(string[1]) == month && year.equals(string[2])) {
                    stackBooking.push(booking);
                    count++;
                }
                if (count == totalVoucher) {
                    break;
                }
            }
            System.out.println("List Customers receive 10% discount:");
            for (int i = 0; i < voucher10; i++) {
                if (!stackBooking.isEmpty()) {
                    for (int j = 0; j < arrayListCustomer.size(); j++) {
                        if (arrayListCustomer.get(j).getIdCustomer() == stackBooking.peek().getIdCustomer()) {
                            System.out.println(i + 1 + ". " + arrayListCustomer.get(j));
                            stackBooking.pop();
                            break;
                        }
                    }
                }
            }
            System.out.println("List Customers receive 20% discount:");
            for (int i = 0; i < voucher20; i++) {
                if (!stackBooking.isEmpty()) {
                    for (int j = 0; j < arrayListCustomer.size(); j++) {
                        if (arrayListCustomer.get(j).getIdCustomer() == stackBooking.peek().getIdCustomer()) {
                            System.out.println(i + 1 + ". " + arrayListCustomer.get(j));
                            stackBooking.pop();
                            break;
                        }
                    }
                }
            }
            System.out.println("List Customers receive 50% discount:");
            for (int i = 0; i < voucher50; i++) {
                if (!stackBooking.isEmpty()) {
                    for (int j = 0; j < arrayListCustomer.size(); j++) {
                        if (arrayListCustomer.get(j).getIdCustomer() == stackBooking.peek().getIdCustomer()) {
                            System.out.println(i + 1 + ". " + arrayListCustomer.get(j));
                            stackBooking.pop();
                            break;
                        }
                    }
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void editList() {

    }


}
