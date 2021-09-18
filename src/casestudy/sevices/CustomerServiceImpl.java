package casestudy.sevices;

import casestudy.model.person.Customer;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {

    static Scanner scanner = new Scanner(System.in);
    List<Customer> customerList  = new LinkedList<>();

    @Override
    public void addList() {

            try {

                System.out.println("Enter name of customer");
                String fullName = scanner.nextLine();
                String birthday;
                do {
                    System.out.println("Enter date of birth  of customer:");
                    birthday = scanner.nextLine();
                }
                while (!Validation.validateBirthday(birthday));
                System.out.println("Enter gender of employee 1.Male/2.Female:");
                String gender =inputGender();
                String idCardNumber;
                do {
                    System.out.println("Enter id card of customer:");
                    idCardNumber = scanner.nextLine();
                } while (!Validation.validateIdCard(idCardNumber));
                String phoneNumber;
                do {
                    System.out.println("Enter phone number of customer:");
                    phoneNumber = scanner.nextLine();
                } while (!Validation.validateNumberPhone(phoneNumber));
                String email;
                do {
                    System.out.println("Enter email of customer:");
                    email = scanner.nextLine();
                } while (!Validation.validateEmail(email));
                String idCustomer = "";
                boolean flag = true;
                while (flag) {
                    try {
                        System.out.println("Enter new employee code");
                        idCustomer = scanner.nextLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    flag = false;
                    for (Customer customer : customerList) {
                        if (customer.getIdCustomer().equals(idCustomer)) {
                            System.out.println("Customer code is exist, please enter again !");
                            flag = true;
                            break;
                        }
                    }
                }
                String customerType = chooseTypeCustomer();
                System.out.println("Enter addressCustomer :");
                String addressCustomer = scanner.nextLine();
                Customer customer = new Customer(fullName, birthday, gender, idCardNumber, phoneNumber, email, idCustomer, customerType, addressCustomer);
                customerList.add(customer);
                ReadAndWrite.writeListCustomerCSV(customerList, "src\\casestudy\\data\\customer.csv", false);
                System.out.println("New more success ");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
    public void displayList() {
        customerList =  ReadAndWrite.getListCustomerFromCSV("src\\casestudy\\data\\customer.csv");
        System.out.println("customerList");
        for (Customer customer :customerList){
            System.out.println(customer.getToSTring());
        }

    }

    @Override
    public void editList() {
        try {
            customerList = ReadAndWrite.getListCustomerFromCSV("casestudy\\data\\customer.csv");
            System.out.println("nhập id mà bạn muốn sửa");
            int idOfEdit = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            for (int i = 0; i < customerList.size(); i++) {
                if (idOfEdit-1 == i ) {
                    check = true;
                    System.out.println("Enter Id you want to edit");
                    System.out.println("1. Do you want to edit name");
                    System.out.println("2. Do you want to edit birthday");
                    System.out.println("3. Do you want to edit gender");
                    System.out.println("4. Do you want to edit idcarnumder");
                    System.out.println("5. Do you want to edit email");
                    System.out.println("6. Do you want to edit customertybe");
                    System.out.println("7. Do you want to edit adressofcustomer");
                    System.out.println("0. Return main menu");
                    System.out.print("Enter 0 đến 7 : ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            String inputNewName = "";
                            try {
                                System.out.println("Enter new name of customer : ");
                                inputNewName = scanner.nextLine();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            customerList.get(i).setFullName(inputNewName);
                            break;
                        case 2:
                            String inputNewBirthday = "";
                            try {
                                do {
                                    System.out.println("Enter new date of birth  of customer : ");
                                    inputNewBirthday = scanner.nextLine();
                                }
                                while (!Validation.validateBirthday(inputNewBirthday));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            customerList.get(i).setBirthday(inputNewBirthday);
                            break;
                        case 3:
                            String inputGender = "";
                            try {
                                System.out.println("Enter new gender of customer : ");
                                inputGender = inputGender;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            customerList.get(i).setGender(inputGender);
                            break;
                        case 4:
                            String inputIdCard = "";
                            try {
                                System.out.println("Enter new id card of customer : ");
                                inputIdCard = scanner.nextLine();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            customerList.get(i).setIdCardNumber(inputIdCard);
                            break;
                        case 5:
                            String inputNewEmail = "";
                            try {
                                System.out.println("Enter new email of customer : ");
                                inputNewEmail = scanner.nextLine();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            customerList.get(i).setEmail(inputNewEmail);
                            break;
                        case 6:
                            String inputNewTypeCustomer = chooseTypeCustomer();
                            customerList.get(i).setCustomerType(inputNewTypeCustomer);
                            break;
                        case 7:
                            String inputNewAddressCustomer = "";
                            try {
                                System.out.println("Enter new address of customer : ");
                                inputNewAddressCustomer = scanner.nextLine();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            customerList.get(i).setAddressCustomer(inputNewAddressCustomer);
                            break;

                        case 0:
                            break;
                        default:
                            System.out.println("Re-Enter");
                    }
                }

            }
            if (!check){
                System.out.println("Not number in list");
            }


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }
    private static String inputGender() {
        String gender = "";
        boolean check = true;
        while (check) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    gender = "Male";
                } else if (choice == 2) {
                    gender = "Female";
                }
                check =false;
            } catch (Exception e) {
                System.out.println("No matches.Re-Enter: ");
            }
        }
        return gender;
    }
    private String chooseTypeCustomer() {
        System.out.println("Choose type of customer: ");
        String customerType;

        System.out.println("Choose type of customer: "
                + "1.Diamond \n"
                + "2.Platinium \n"
                + "3.Gold \n"
                + "4.Silver \n"
                + "5.Member ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                customerType = "Diamond";
                break;
            case "2":
                customerType = "Platinium";
                break;
            case "3":
                customerType = "Gold";
                break;
            case "4":
                customerType = "Silver";
                break;
            case "5":
                customerType = "Member";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        return customerType;
    }
}
