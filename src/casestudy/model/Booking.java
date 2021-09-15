package casestudy.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking implements Comparable<Booking>{
    private String idBooking; // Mã booking
    private String startDate; // Ngày bắt đầu
    private String endDate; // Ngày kết thúc
    private String idCustomer; // Mã khách hàng
    private String nameService; // Tên dịch vụ
    private String idService; // Mã dịch vụ

    public Booking() {
    }

    public Booking(String idBooking, String startDate, String endDate, String idCustomer, String nameService, String idService) {
        this.idBooking = idBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.idService = idService;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customer='" + idCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                ", idService='" + idService + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate1 =LocalDate.parse(this.getStartDate(),formatter);
        LocalDate startDate2 =LocalDate.parse(o.getStartDate(),formatter);
        LocalDate endtDate1 =LocalDate.parse(this.getEndDate(),formatter);
        LocalDate endtDate2 =LocalDate.parse(o.getEndDate(),formatter);
        if (startDate1.compareTo(startDate2)>0){
            return 1;
        }else if (startDate1.compareTo(startDate2)<0){
            return -1;
        }else {
            if (endtDate1.compareTo(endtDate2)>0){
                return 1;
            }else if (endtDate1.compareTo(endtDate2)<0){
                return -1;
            }else {
                return 0;
            }
        }
    }

}
