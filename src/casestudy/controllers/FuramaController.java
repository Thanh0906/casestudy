package casestudy.controllers;


import casestudy.sevices.*;
import casestudy.utils.Validation;

import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Employee Management ");
            System.out.println("2. Customer Management ");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Management ");
            System.out.println("5. Promotion Management ");
            System.out.println("6. Exit ");
            System.out.println("Enter your choice: ");
                choice =   Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                        int choiceNumber1 = -1;
                        do {
                            System.out.println("1. Display list employees ");
                            System.out.println("2. Add new employee ");
                            System.out.println("3. Edit employee ");
                            System.out.println("4. Return main menu ");
                            System.out.println("Enter your choice: ");
                            choiceNumber1 = Integer.parseInt(scanner.nextLine());
                            switch (choiceNumber1) {
                                case 1:
                                    employeeService.displayList();
                                    break;
                                case 2:
                                    employeeService.addList();
                                    break;
                                case 3:
                                    employeeService.editList();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Error. Please re-enter your choice.");
                            }
                        } while (choiceNumber1 != 4);
                        break;
                    case 2:
                        CustomerServiceImpl customerService = new CustomerServiceImpl();
                        int choiceNumber2 = -1;
                        do {
                            System.out.println("1. Display list customers ");
                            System.out.println("2. Add new customer ");
                            System.out.println("3. Edit customer ");
                            System.out.println("4. Return main menu ");
                            System.out.println("Enter your choice: ");
                            choiceNumber2 = Integer.parseInt(scanner.nextLine());
                            switch (choiceNumber2) {
                                case 1:
                                    customerService.displayList();
                                    break;
                                case 2:
                                    customerService.addList();
                                    break;
                                case 3:
                                    customerService.editList();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Error. Please re-enter your choice.");
                            }
                        } while (choiceNumber2 != 4);
                        break;
                    case 3:
                        FacilityServiceImpl facilityService = new FacilityServiceImpl();
                        int choiceNumber3 = -1;
                        do {
                            System.out.println("1. Display list facility ");
                            System.out.println("2. Add new facility ");
                            System.out.println("3. Display list facility maintenance ");
                            System.out.println("4. Return main menu ");
                            System.out.println("Enter your choice: ");
                            choiceNumber3 = Integer.parseInt(scanner.nextLine());
                            switch (choiceNumber3) {
                                case 1:
                                    facilityService.displayList();
                                    break;
                                case 2:
                                    facilityService.addList();
                                    break;
                                case 3:
                                    facilityService.displayListForMaintenance();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Error. Please re-enter your choice.");
                            }
                        } while (choiceNumber3 != 4);
                        break;
                    case 4:
                        BookingServiceImpl bookingService = new BookingServiceImpl();
                        ContactServiceImpl contactService = new ContactServiceImpl();
                        int choiceNumber4 = -1;
                        do {
                            System.out.println("1. Add new booking ");
                            System.out.println("2. Display list booking ");
                            System.out.println("3. Create new contracts ");
                            System.out.println("4. Display list contracts ");
                            System.out.println("5. Edit contracts ");
                            System.out.println("6. Return main menu ");
                            System.out.println("Enter your choice: ");
                            choiceNumber4 = Integer.parseInt(scanner.nextLine());
                            switch (choiceNumber4) {
                                case 1:
                                    bookingService.addList();
                                    break;
                                case 2:
                                    bookingService.displayList();
                                    break;
                                case 3:
                                    contactService.addList();
                                    break;
                                case 4:
                                    contactService.displayList();
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                default:
                                    System.out.println("Error. Please re-enter your choice.");
                            }
                        } while (choiceNumber4 != 6);
                        break;
                    case 5:
                        PromotionServiceImpl promotionService= new PromotionServiceImpl();
                        int choiceNumber5;
                        do {
                            System.out.println("1. Display list customers use service ");
                            System.out.println("2. Display list customers get voucher ");
                            System.out.println("3. Return main menu ");
                            System.out.println("Enter your choice: ");
                            choiceNumber5 = Integer.parseInt(scanner.nextLine());
                            switch (choiceNumber5) {
                                case 1:
                                    promotionService.displayList();
                                    break;
                                case 2:
                                    promotionService.displayPromotion();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Error. Please re-enter your choice.");
                            }
                        } while (choiceNumber5 != 3);
                        break;
                    case 6:
                        System.exit(6);
                }

        } while (choice != 6);

    }

    public static void main(String[] args) {
        displayMainMenu();
    }

}
