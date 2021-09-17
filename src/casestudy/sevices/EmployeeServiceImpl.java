package casestudy.sevices;

import casestudy.model.person.Employee;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static List<Employee> employeeList = new ArrayList<Employee>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addList() {
        try {
            System.out.println("Enter Name :");
            String fullName = scanner.nextLine();
            System.out.println("Enter birthday  :");
            String birthday = Validation.inputDay();
            System.out.println("Enter gender : 1. Male / 2. Female:");
            String gender = Validation.inputGender();
            System.out.println("Enter IdCardNumber:");
            String idCardNumber = scanner.nextLine();//Validation.inputIdCardNumber();
            System.out.println("Enter phonenumber:");
            String phoneNumber = Validation.inputNumberphone();
            System.out.println("Enter Email :");
            String email = Validation.inputEmail();
            System.out.println("Enter level :");
            String level = Validation.inputLevel();
            System.out.println("Enter positio :");
            String position = scanner.nextLine();
            System.out.println("Enter salary :");
            double salary = Validation.inputDouble();
            Employee employee = new Employee(fullName, birthday, gender, idCardNumber, phoneNumber,
                    email, level, position, salary);
            employeeList.add(employee);
            ReadAndWrite.writeListEmployeeCSV(employeeList,"src\\casestudy\\data\\employee.csv",true);
            System.out.println("New more success ");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void displayList()  {
        employeeList = ReadAndWrite.getListEmployeeFromCSV("src\\casestudy\\data\\employee.csv");
        System.out.println("List Employee");
        for (Employee employee:employeeList) {
            System.out.println(employee.getToString());
        }

    }

    @Override
    public void editList() {
        try {
            employeeList = ReadAndWrite.getListEmployeeFromCSV("src\\casestudy\\data\\employee.csv");
            System.out.println("Enter Id you want to edit ");
            int idOfEdit = Validation.inputNumber();
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
                            System.out.print("Enter edit birthDay: DD/MM/YYYY");
                            String inputNewBirthday = Validation.inputBirthday();
                            employeeList.get(i).setBirthday(inputNewBirthday);
                            break;
                        case 3:
                            System.out.print("Enter edit gender 1.Male / 2.FeMale: ");
                            String inputNewSex = Validation.inputGender();
                            employeeList.get(i).setGender(inputNewSex);
                            break;
                        case 4:
                            System.out.print("Enter edit id Number: ");
                            String inputNewId = scanner.nextLine();
                            employeeList.get(i).setIdCardNumber(inputNewId);
                            break;
                        case 5:
                            System.out.print("Enter edit Email ");
                            String inputNewEmail = Validation.inputEmail();
                            employeeList.get(i).setEmail(inputNewEmail);
                            break;
                        case 6:
                            System.out.print("Emter edit level ");
                            String inputNewLevel = Validation.inputLevel();
                            employeeList.get(i).setLevel(inputNewLevel);
                            break;
                        case 7:
                            System.out.print("Enter  edit position: ");
                            String inputNewPosition = scanner.nextLine();
                            employeeList.get(i).setPosition(inputNewPosition);
                            break;
                        case 8:
                            System.out.print("Enter edit salary ");
                            double inputNewSalary = Validation.inputDouble();
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
}
