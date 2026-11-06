package DTO;

public class AccountException {

    private boolean isValidAccount;//nhan vao la 1 cai dto tu dong 13 /done
    private boolean isValidName;//done
    private boolean isValidAge;
    private boolean isValidAddress;
    private boolean isValidEmail;
    private boolean isValidPhoneNumber;
    private boolean isValidPassword;//done

    private AccountDTO data;

    public AccountException(AccountDTO acc) {
        this.data = acc;
        checkAll();
    }

//    private boolean checkValidAccount() {
//        try {
//            String regex = "^[a-zA-Z0-9._%+-]{1,20}$";
//            if (this.data.getAccount().matches(regex)) {
//                this.isValidAccount = true;
//            }
//            return true;
//        } catch (Exception e) {
//            System.out.println("checkValidAccount() " + e.getMessage());
//            return false;
//        }
//
//    }
    private boolean checkValidPassword() {
        try {
            String regex = "^[a-zA-Z0-9._%+-]{1,200}$";
            if (this.data.getPassword().matches(regex)) {
                this.isValidPassword = true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("checkValidName" + e.getMessage());
            return false;
        }
    }

    private boolean checkValidName() {
        try {
            String regex = "^[a-zA-Z\\s]{1,30}$";
            if (this.data.getName().matches(regex)) {
                this.isValidName = true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("checkValidName" + e.getMessage());
            return false;
        }
    }

    private boolean checkValidEmail() {
        try {
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,50}$";
            if (this.data.getEmail().matches(regex)) {
                this.isValidEmail = true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("checkValidEmail()" + e.getMessage());
            return false;
        }
    }

    private boolean checkValidAge() {
        try {
            String regex = "^[0-9]{1,3}$";
            if (this.data.getAge().matches(regex)) {
                this.isValidAge = true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("checkValidAge" + e.getMessage());
            return false;
        }
    }

    private boolean checkValidAddress() {
        try {
            String regex = "^[a-zA-Z0-9\\s,./-]{1,50}$";
            if (this.data.getAddress().matches(regex)) {
                this.isValidAddress = true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("checkValidAddress()" + e.getMessage());
            return false;
        }
    }

    private boolean checkValidPhoneNumber() {
        try {
            String regex = "^(0|\\+84)[0-9]{9}$";
            if (this.data.getPhoneNumber().matches(regex)) {
                this.isValidPhoneNumber = true;
            }
            return true;
        } catch (Exception e) {
            System.out.println("checkValidPhoneNumber())" + e.getMessage());
            return false;
        }
    }

    public void checkAll() {
//        checkValidAccount();
        checkValidAddress();
        checkValidAge();
        checkValidEmail();
        checkValidName();
        checkValidPassword();
        checkValidPhoneNumber();
    }

    public boolean isIsValidAccount() {
        return isValidAccount;
    }

    public boolean isIsValidName() {
        return isValidName;
    }

    public boolean isIsValidAge() {
        return isValidAge;
    }

    public boolean isIsValidAddress() {
        return isValidAddress;
    }

    public boolean isIsValidEmail() {
        return isValidEmail;
    }

    public boolean isIsValidPhoneNumber() {
        return isValidPhoneNumber;
    }

    public boolean isIsValidPassword() {
        return isValidPassword;
    }

    public AccountDTO getData() {
        return data;
    }
    public boolean isValid(){
        return isValidAddress && isValidAge && isValidEmail && isValidName && isValidPassword && isValidPassword && isValidPhoneNumber;
    }
}
