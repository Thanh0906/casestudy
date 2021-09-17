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
            String numberContract = scanner.nextLine();
            System.out.println("Enter idBooking");
            String idBooking = queueBooking.peek().getIdBooking();
            System.out.println("Enter deposit");
            double deposit = Validation.inputDouble();
            System.out.println("Enter totalPayment");
            double totalPayment =Validation.inputDouble();
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
            int idContract =Validation.inputNumber();
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
                            System.out.println("Enter edit numberContract");
                            String numberContract =scanner.nextLine();
                            contractList.get(i).setNumberContract(numberContract);
                            break;
                        case 2:
                            System.out.println("Enter edit idBooking");
                            String idBooking =scanner.nextLine();
                            contractList.get(i).setIdBooking(idBooking);
                            break;
                        case 3:
                            System.out.println("Enter edit deposit");
                           double deposit =Validation.inputDouble();
                            contractList.get(i).setDeposit(deposit);
                            break;
                        case 4:
                            System.out.println("Enter edit totalPayment");
                            Double totalPayment =Validation.inputDouble();
                            contractList.get(i).setTotalPayment(totalPayment);
                            break;
                        case 5:
                            System.out.println("Enter edit idCustomer");
                            String idCustomer =scanner.nextLine();
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
