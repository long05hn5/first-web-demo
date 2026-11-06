package Entity;

public class Account {

    private int id;
    private String account;
    private String name;
    private int age;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;

    public Account() {
    }

    public Account(String name, int age, String address, String email, String phoneNumber, String password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    
    public Account(String account, String name, String password) {
        this.account = account;
        this.name = name;
        this.password = password;
    }

    public Account(int id, String account, String name, int age, String address, String email) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public Account(int id, String account, String name, int age, String address, String email, String phoneNumber, String password) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Account(int id, String account, String name, int age, String address, String email, String phoneNumber) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }//default cua 1 class

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", account=" + account + ", name=" + name + ", age=" + age + ", address=" + address + ", email=" + email + ", password=" + password + '}';
    }
    

}
