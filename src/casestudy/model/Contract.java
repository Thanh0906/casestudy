package casestudy.model;

public class Contract {
    //hợp đồng
    private String numberContract;//số hợp đòng
    private String idBooking; // Mã booking
    private double deposit; // Số tiền cọc
    private double totalPayment; // Tổng số tiền thanh toán
    private String idCustomer; // Mã khách hàng

    public Contract() {

    }

    public Contract(String numberContract, String idBooking, double deposit, double totalPayment, String idCustomer) {
        this.numberContract = numberContract;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.idCustomer = idCustomer;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContract='" + numberContract + '\'' +
                ", idBooking='" + idBooking + '\'' +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", idCustomer='" + idCustomer + '\'' +
                '}';
    }
    public String getToString(){
        return this.getNumberContract() + "," +this.getIdBooking()+ "," +this.getDeposit() + ","+this.getTotalPayment()+ ","+ this.getIdCustomer();
    }
}
