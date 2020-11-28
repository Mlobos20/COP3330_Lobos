import java.io.Serializable;

public class ContactItem implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private boolean isEmpty;

    public ContactItem(String fname, String lname, String pNumber, String eAdd){
        this.firstName = fname;
        this.lastName = lname;
        this.phoneNumber = pNumber;
        this.emailAddress = eAdd;

        checkEmpty();
    }

    public void checkEmpty(){
        if(this.firstName.length() == 0 && this.lastName.length()== 0 && this.phoneNumber.length() == 0 && this.emailAddress.length() == 0){
            this.isEmpty = true;
        }
        else{
            this.isEmpty = false;
        }
    }

    public boolean returnEmptyStatus(){
        return this.isEmpty;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString(){
        return(this.firstName + " " + this.lastName + "%n" + "Phone Number: " + this.phoneNumber + "%n" + "Email Address: " + this.emailAddress + "%n");
    }

}
