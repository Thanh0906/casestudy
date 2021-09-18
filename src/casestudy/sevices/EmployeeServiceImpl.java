package casestudy.sevices;

import casestudy.model.person.Employee;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<Employee>();
    @Override
    public void addList() {
        List<Employee> employeeList = ReadAndWrite.getListEmployeeFromCSV("src\\casestudy\\data\\employee.csv");

        try {

            String fullName;
            do {
                System.out.println("Enter name of employee");
                fullName = scanner.nextLine();
            }
            while (!Validation.validateNameService(fullName));

            String birthday;

            do {
                System.out.println("Enter date of birth  of employee:");
                birthday = scanner.nextLine();
            }
            while (!Validation.validateBirthday(birthday));

            System.out.println("Enter gender of employee 1.Male/2.Female:");
            String gender =inputGender();

            String idCardNumber;
            do {
                System.out.println("Enter id card of employee:");
                idCardNumber = scanner.nextLine();
            }
            while (!Validation.validateIdCard(idCardNumber));

            String phoneNumber;
            do {
                System.out.println("Enter phone number of employee:");
                phoneNumber = scanner.nextLine();
            }
            while (!Validation.validateNumberPhone(phoneNumber));

            String email;
            do {
                System.out.println("Enter email of employee:");
                email = scanner.nextLine();
            }
            while (!Validation.validateEmail(email));
            String level = chooseLevel();
            String position = choosePosition();
            int salary;
            do {
                System.out.println("Enter salary of employee:");
                salary = Integer.parseInt(scanner.nextLine());
            } while (!Validation.validateSalary(salary));

            employeeList.add(new Employee(fullName,birthday,gender,idCardNumber,phoneNumber,email,level,position,salary));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Add employee completed !");
        ReadAndWrite.writeListEmployeeCSV(employeeList, "src\\casestudy\\data\\employee.csv",false);
        displayList();


    }

    @Override
    public void displayList() {
        employeeList = ReadAndWrite.getListEmployeeFromCSV("src\\casestudy\\data\\employee.csv");
        System.out.println("List Employee");
        for (Employee employee:employeeList) {
            System.out.println(employee.getToString());
        }

    }

    @Override
    public void editList() {
        displayList();
        try {
            employeeList = ReadAndWrite.getListEmployeeFromCSV("src\\casestudy\\data\\employee.csv");
            System.out.println("Enter Id you want to edit ");
            int idOfEdit = Integer.parseInt(scanner.nextLine());
            boolean check = false;
            for (int i = 0; i < employeeList.size(); i++) {
                if (idOfEdit - 1 == i) {
                    check = true;
                    System.out.println("What do you want to edit??");
                    System.out.println("1. Do you want to edit name ");
                    System.out.println("2. Do you want to edit birthday");
                    System.out.println("3. Do you want to edit gender");
                    System.out.println("4. Do you want to edit idcard");
                    System.out.println("5. Do you want to edit email");
                    System.out.println("6. Do you want to edit Level ");
                    System.out.println("7. Do you want to edit position");
                    System.out.println("8. Do you want to edit salary   ");
                    System.out.println("0. Return main menu");
                    System.out.print("Enter 0 - 8 : ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Enter edit Full Name:  ");
                            String inputNewName = scanner.nextLine();
                            employeeList.get(i).setFullName(inputNewName);
                            break;
                        case 2:
                            String inputNewBirthday = "";
                            try {
                                do {
                                    System.out.print("Enter edit birthDay: DD/MM/YYYY");
                                    inputNewBirthday = scanner.nextLine();
                                }
                                while (!Validation.validateBirthday(inputNewBirthday));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            employeeList.get(i).setBirthday(inputNewBirthday);
                            break;

                        case 3:
                            String gender = "";
                            try {
                                System.out.print("Enter edit gender 1.Male / 2.FeMale: ");
                                gender = inputGender();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            employeeList.get(i).setGender(gender);
                            break;
                        case 4:
                            String inputNewId = "";
                            try {
                                System.out.print("Enter edit id Number: ");
                                inputNewId = scanner.nextLine();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            employeeList.get(i).setIdCardNumber(inputNewId);
                            break;
                        case 5:
                            String email = "";
                            try {
                                System.out.println("Enter new email of employeee : ");
                                email = scanner.nextLine();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                           employeeList.get(i).setEmail(email);
                            break;
                        case 6:
                            System.out.print("Emter edit level ");
                            String level = chooseLevel();
                            employeeList.get(i).setLevel(level);
                            break;
                        case 7:
                            System.out.print("Enter  edit position: ");
                            String inputNewPosition = choosePosition();
                            employeeList.get(i).setPosition(inputNewPosition);
                            break;
                        case 8:
                            double inputNewSalary=0;
                            try {
                                System.out.print("Enter edit salary ");
                                inputNewSalary= Double.parseDouble(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            employeeList.get(i).setSalary(inputNewSalary);
                            break;

                        case 0:
                            break;
                        default:
                            System.out.println("error.Please re-enter  ");
                    }
                }

            }
            if (!check) {
                System.out.println("id already exists.Please re-enter ");
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
    private String chooseLevel() {
        String level;
        System.out.println("Choose level: "
                + "1.Intermediate \n"
                + "2.College \n"
                + "3.University \n"
                + "4.Postgraduate");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                level = "Intermediate";
                break;
            case "2":
                level = "College";
                break;
            case "3":
                level = "University";
                break;
            case "4":
                level = "Postgraduate";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        return level;
    }

    private String choosePosition() {

        String position;

        System.out.println("Choose position: "
                + "1.Receptionist \n" //Lễ tân
                + "2.Staff \n" //phục vụ
                + "3.Expert \n" //chuyên viên
                + "4.Monitor \n" //Giám sát
                + "5.Manager \n"  //Quản lý
                + "6.Direction"); //giám đốc
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                position = "Receptionist";
                break;
            case "2":
                position = "Staff";
                break;
            case "3":
                position = "Expert";
                break;
            case "4":
                position = "Monitor";
                break;
            case "5":
                position = "Manager";
                break;
            case "6":
                position = "Direction";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
        return position;
    }
}
