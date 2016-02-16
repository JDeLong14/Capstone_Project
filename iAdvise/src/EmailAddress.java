
import java.io.Serializable;

public class EmailAddress implements Serializable {

    //serializing the email address that was obtained in either panel
    //gathering up the information about the email address
    //setting up the email address, and if there is no @ and . in the 
    //email address, there will be an error displayed
    //after it is all read and checked, the email will be put 
    //into a tostring
    
    private String email;

    public EmailAddress() {
        this("N/A");
    }

    public EmailAddress(String email) {
        this.setEmail(email);
    }

    public EmailAddress(EmailAddress that) {
        this(that.email);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!email.equals("N/A")) {
            if ((email.indexOf("@") == -1) || (email.indexOf(".") == -1)) {
                throw new InvalidException("Invalid email address\nCorrect Format: johndoe@gmail.com");
            }
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s", this.email);
    }
}
