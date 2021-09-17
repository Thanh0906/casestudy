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
            System.out.println("Ennter Name :");
            String fullName = scanner.nextLine();
            System.out.println("Enter birthday :");
            String birthday= Validation.inputBirthday();
            System.out.println("Enter gender 1.Male / 2.Female :");
            String gender = Validation.inputGender();
            System.out.println("Enter IdCardNumber :");
            String idCardNumber =scanner.nextLine();
            System.out.println("Enter phonenumber");
            String phoneNumber =Validation.inputNumberphone();
            System.out.println("Enter Email :");
            String email = Validation.inputEmail();
            System.out.println("Enter idCustomer");
            String idCustomer =scanner.nextLine();
            System.out.println("Enter customerTybe 1. Diamond / 2. Platinium /3. Gold / 4. Silver / 5. Member:");
            String customerType = Validation.inputcustomerType();
            System.out.println("Enter addressCustomer :");
            String addressCustomer = scanner.nextLine();
            Customer customer = new Customer(fullName,birthday,gender,idCardNumber,phoneNumber,email,idCustomer,customerType,addressCustomer);
            customerList.add(customer);
            ReadAndWrite.writeListCustomerCSV(customerList,"src\\casestudy\\data\\customer.csv",true  );
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
                            System.out.print("Enter edit name: ");
                            String inputNewName = scanner.nextLine();
                            customerList.get(i).setFullName(inputNewName);
                            break;
                        case 2:
                            System.out.print("Enter edit birthDay: DD/MM/YYYY");
                            String inputNewBirthday = Validation.inputBirthday();
                            customerList.get(i).setBirthday(inputNewBirthday);
                            break;
                        case 3:
                            System.out.print("Enter edit gender 1.Male /2.Female: ");
                            String inputNewSex = Validation.inputGender();
                            customerList.get(i).setGender(inputNewSex);
                            break;
                        case 4:
                            System.out.print("Enter edit idcardnumber ");
                            String inputNewId = scanner.nextLine();
                            customerList.get(i).setIdCardNumber(inputNewId);
                            break;
                        case 5:
                            System.out.print("Enter edit email ");
                            String inputNewEmail = Validation.inputEmail();
                            customerList.get(i).setEmail(inputNewEmail);
                            break;
                        case 6:
                            System.out.print("Enter edit tybecustomer ");
                            String inputNewTypeCustomer = scanner.nextLine();
                            customerList.get(i).setCustomerType(inputNewTypeCustomer);
                            break;
                        case 7:
                            System.out.print("Enter edit adressofcustomer: ");
                            String inputNewAddressCustomer = scanner.nextLine();
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
}
