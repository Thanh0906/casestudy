package casestudy.model.person;

public class Customer extends Person {
    //khách hàng
    private String idCustomer; // Mã khách hàng
    private String customerType; // Loại khách hàng: diamond, platinium, gold, silver, member
    private String addressCustomer; // Địa chỉ của khách hàng

    public Customer (){}
    public Customer( String fullName, String birthday, String gender, String idCardNumber,
                     String phoneNumber, String email, String idCustomer, String customerType,
                     String addressCustomer) {
        super(fullName, birthday, gender, idCardNumber, phoneNumber, email);
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.addressCustomer = addressCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString()+
                "idCustomer='" + idCustomer + '\'' +
                ", customerType='" + customerType + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                '}';
    }
    public String getToSTring(){
        return this.getFullName() + "," + this.getBirthday() + "," + this.getGender() + "," +getIdCardNumber()
                +"," + this.getPhoneNumber() +"," + this.getEmail() + "," +this.getIdCustomer() +"," +this.getCustomerType()
                + ","+this.getAddressCustomer();
    }
}
