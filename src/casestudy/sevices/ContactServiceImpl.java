package casestudy.sevices;

import casestudy.model.Booking;
import casestudy.model.Contract;
import casestudy.utils.ReadAndWrite;
import casestudy.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ContactServiceImpl implements IContactService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void addList() {
        try {
            Queue<Booking> queueBooking = ReadAndWrite.getQueueBookingFromCSV("casestudy\\data\\queueBooking.csv");
            System.out.println("Enter  number contracts : ");

            String numberContract = "";
            boolean flag = true;
            while (flag) {
                try {
                    System.out.println("Enter number of contract");
                    numberContract = scanner.nextLine();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                flag = false;
                for (Contract contract : contractList) {
                    if (contract.getNumberContract().equals(numberContract)) {
                        System.out.println("Contract number is exist, please enter again !");
                        flag = true;
                        break;
                    }
                }

            }
            System.out.println("Enter idBooking");
            String idBooking = queueBooking.peek().getIdBooking();
            System.out.println("Enter deposit");
            double deposit = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter totalPayment");
            double totalPayment =Double.parseDouble(scanner.nextLine());
            System.out.println("idCustomer");
            String idCustomer = BookingServiceImpl.queueBooking.peek().getIdCustomer();
            Contract contract = new Contract(numberContract,idBooking,deposit,totalPayment,idCustomer);
            contractList.add(contract);
            ReadAndWrite.writeListContractCSV(contractList,"src\\casestudy\\data\\contract.csv",true);
            queueBooking.remove();
            ReadAndWrite.writeQueueBookingCSV(queueBooking,"src\\casestudy\\data\\queueBooking.csv",false);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void displayList() {
        contractList = ReadAndWrite.getListContractFromCSV("src\\casestudy\\data\\contract.csv");
        System.out.println("list Contract: ");
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }

    }

    @Override
    public void editList() {
        displayList();
        boolean flag = false;
        while (flag){
            System.out.println("Enter number Contract");
            int idContract =Integer.parseInt(scanner.nextLine());
            for (int i =0;i<contractList.size();i++){
                if (idContract -1 ==i){
                    flag = true;
                    System.out.println("What do you want to edit??");
                    System.out.println("1. Do you want to edit numberContract ");
                    System.out.println("2. Do you want to edit idBooking");
                    System.out.println("3. Do you want to edit deposit");
                    System.out.println("4. Do you want to edit totalPayment");
                    System.out.println("5. Do you want to edit idCustomer");
                    System.out.println("0. Return main menu ");
                    System.out.print("Enter 0 - 5 : ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            String numberContract="";
                            try {
                                System.out.println("Enter number of Contract");
                                numberContract = scanner.nextLine();
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            contractList.get(i).setNumberContract(numberContract);
                            break;
                        case 2:
                            String idBooking="";
                            try {
                                System.out.println("Enter edit idBooking");
                                idBooking = scanner.nextLine();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            contractList.get(i).setIdBooking(idBooking);
                            break;
                        case 3:
                            double deposit=0;
                            try {
                                System.out.println("Enter edit deposit of Contract");
                                 deposit =Double.parseDouble(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            contractList.get(i).setDeposit(deposit);
                            break;
                        case 4:
                            double totalPayment=0;
                            try {
                                System.out.println("Enter edit totalPayment");
                                totalPayment =Double.parseDouble(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            contractList.get(i).setTotalPayment(totalPayment);
                            break;
                        case 5:
                            String idCustomer="";
                            try{
                                System.out.println("Enter customer code Contract");
                                idCustomer = scanner.nextLine();}
                            catch (Exception e) {
                                e.printStackTrace();
                            }
                            contractList.get(i).setIdCustomer(idCustomer);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("error.Please re-enter  ");
                    }

                }
                if (!flag) {
                    System.out.println("id already exists.Please re-enter ");
                }
            }
        }
        ReadAndWrite.writeListContractCSV(contractList,"src\\casestudy\\data\\contract.csv",false);
    }
}
