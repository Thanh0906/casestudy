package casestudy.model.person;

public class Employee extends Person {
    //nhân viên
    private String level;//trihf độ Trung cấp, Cao đẳng, Đại học và sau đại học
    private String position;//vị trí Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc.
    private double salary;//luong

    public Employee() {
    }

    public Employee( String fullName, String birthday, String gender, String idCardNumber,
                     String phoneNumber, String email, String level, String position, double salary) {
        super(fullName, birthday, gender, idCardNumber, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +super.toString()+
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
    public String getToString(){
        return this.getFullName() + ","+this.getBirthday() + ","+this.getGender() + "," +getIdCardNumber() +","+ this.getPhoneNumber() +","+this.getEmail() +","+this.getLevel()+","+this.getPosition()+","+this.getSalary();
    }
}
