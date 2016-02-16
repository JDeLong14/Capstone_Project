
import java.io.Serializable;

public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 1L;
    private String phoneNumber;

    public PhoneNumber() {
        this("0000000000");
    }

    // gathers up the setters and getters for the program
    public PhoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
    }

    public PhoneNumber(PhoneNumber that) {
        this(that.phoneNumber);
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    //throws an exception if the # has letters in it
    public void setPhoneNumber(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                throw new InvalidException("A phone number can only contain digits\nCorrect Format: XXXXXXXXXX");
            }
        }

        //throws an exception if the # has more than 10 digits or less then 10 digits
        if (phoneNumber.length() != 10) {
            throw new InvalidException("A phone number can only be 10 digits long (with area code)\n"
                    + "Correct Format: XXXXXXXXXX");
        }
        this.phoneNumber = phoneNumber;
    }

    //converts the number into a formatted toString
    @Override
    public String toString() {
        return String.format("(%s)%s-%s",
                this.phoneNumber.substring(0, 3),
                this.phoneNumber.substring(3, 6),
                this.phoneNumber.substring(6));
    }

    public void convert(String line) {
        phoneNumber = line.substring(2, 5) + line.substring(6, 9) + line.substring(10, line.length());
    }
}
