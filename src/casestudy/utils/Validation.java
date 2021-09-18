package casestudy.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    static Scanner scanner = new Scanner(System.in);

    public static boolean validateNameService(String nameService) {
        final String SERVICE_NAME_REGEX = "^[A-Z][A-z]*";

        if (nameService.matches(SERVICE_NAME_REGEX)) {
            return true;
        } else {
            System.err.println("Please enter again, wrong text format !");
            return false;
        }

    }

    public static boolean validateSalary(double salary) {
        if (salary > 0) {
            return true;
        } else {
            System.err.println("Please enter salary again, salary must be greater than zero !");
            return false;
        }
    }

    public static boolean validateIdCard(String idCard) {
        final String ID_CARD_REGEX = "\\d{9}";
        if (idCard.matches(ID_CARD_REGEX)) {
            return true;
        } else {
            System.err.println("Please enter again, id card is 9-digit string ");
            return false;
        }
    }

    public static boolean validateNumberPhone(String numberPhone) {
        final String NUMBER_PHONE_REGEX = "\\d{10}";
        if (numberPhone.matches(NUMBER_PHONE_REGEX)) {
            return true;
        } else {
            System.err.println("Please enter again, number of phone is 10-digit string ");
            return false;
        }
    }

    public static boolean validateEmail(String email) {
        final String EMAIL_REGEX = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}";
        if (email.matches(EMAIL_REGEX)) {
            return true;
        } else {
            System.err.println("Please enter again, wrong email format !");
            return false;
        }
    }

    public static boolean validateCodeService(String codeOfService) {
        final String CODE_SERVICE_REGEX = "^[SV]+(VL|HO|RO)+[-]+\\d{4}";

        if (codeOfService.matches(CODE_SERVICE_REGEX)) {
            return true;
        } else {
            System.err.println("Please enter again, wrong text format !");
            return false;

        }
    }

    public static boolean validateArea(double area) {
        if (area > 30) {
            return true;
        } else {
            System.err.println("Please enter area again, area must be greater than 30");
            return false;
        }
    }

    public static boolean validatePoolArea(double poolArea) {
        if (poolArea > 30) {
            return true;
        } else {
            System.err.println("Please enter area again, area of pool must be greater than 30");
            return false;
        }
    }

    public static boolean validateCost(int cost) {
        if (cost > 0) {
            return true;
        } else {
            System.err.println("Please enter cost again, Cost must be more than zero !");
            return false;
        }
    }

    public static boolean validateNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople > 0 && numberOfPeople < 20) {
            return true;
        } else {
            System.err.println("Please enter  again, Number of people must be greater than 0 and less than 20 !");
            return false;
        }
    }

    public static boolean validateNumberOfFloor(int numberOfFloor) {
        if (numberOfFloor > 0) {
            return true;
        } else {
            System.err.println("Please enter again, number of floor must be greater than 0 !");
            return false;
        }
    }

    public static boolean validateRentalType(String rentalType) {
        final String RENTAL_TYPE_REGEX = "^[A-Z][A-z]*";

        if (rentalType.matches(RENTAL_TYPE_REGEX)) {
            return true;
        } else {
            System.err.println("Please enter again, wrong text format !");
            return false;
        }

    }

    public static boolean validateRoomStandard(String roomStandard) {
        final String RENTAL_TYPE_REGEX = "^[A-Z][A-z]*";

        if (roomStandard.matches(RENTAL_TYPE_REGEX)) {
            return true;
        } else {
            System.err.println("Please enter again, wrong text format !");
            return false;
        }
    }

    public static boolean validateDateOfBirth(String dateOfBirth) {
        final String DATE_OF_BIRTH_REGEX = "(([1-2]{1}+[\\d]{1})|(0+[1-9]{1})|(3+[0-1]))+(\\/)+((0+[1-9]{1})|(1+[0-2]{1}))+(\\/)+[\\d]{4}";
        try {
            if (!dateOfBirth.matches(DATE_OF_BIRTH_REGEX)) {
                throw new DateFormatException("Wrong format, please enter again.");
            }
        } catch (DateFormatException e) {
            System.err.println(e.getString() + "(dd/mm/yyyy)");
            return false;
        }
        String[] arrayDate = dateOfBirth.split("/");
        int day = Integer.parseInt(arrayDate[0]);
        int month = Integer.parseInt(arrayDate[1]);
        int year = Integer.parseInt(arrayDate[2]);
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        Date date1;
        Date date2;
        long getDayDiff = 0;
        try {
            String startDate = "" + day + "-" + month + "-" + year;
            String endDate = simpleDateFormat.format(currentDate);
            date1 = simpleDateFormat.parse(startDate);
            date2 = simpleDateFormat.parse(endDate);
            long getDiff = date2.getTime() - date1.getTime();

            getDayDiff = getDiff / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean checkDateMin = getDayDiff / 365 > 18;
        boolean checkDateMax = getDayDiff / 365 < 100;
        try {
            if (!checkDateMax) {
                throw new AgeFormatException("Age must be less than 100, please enter again !");
            }
        } catch (AgeFormatException e) {
            System.err.println(e.getString());
            return false;
        }
        try {
            if (!checkDateMin) {
                throw new AgeFormatException("Age must be greater than 18, please enter again !");
            }
        } catch (AgeFormatException e) {
            System.err.println(e.getString());
            return false;
        }
        return true;
    }
}

