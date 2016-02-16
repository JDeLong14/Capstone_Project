
import java.io.Serializable;

public class Name implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private char middleInitial;

    public Name() {
        this("", "N/A", ' ');
    }

    //gather up the setters and getters for the program
    public Name(String firstName, String lastName, char middleInitial) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMiddleInitial(middleInitial);
    }

    public Name(Name that) {
        this(that.firstName, that.lastName, that.middleInitial);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public char getMiddleInitial() {
        return this.middleInitial;
    }

    //Throws an exception if the name has digits in it
    public void setFirstName(String firstName) {
        if (!firstName.equals("N/A")) {
            for (int i = 0; i < firstName.length(); i++) {
                if (!Character.isLetter(firstName.charAt(i))) {
                    throw new InvalidException("A name can only contain letters");
                }
            }
        }
        this.firstName = firstName;
    }


    //Throws an exception if the name has digits in it
    public void setLastName(String lastName) {
        if (!lastName.equals("N/A")) {
            for (int i = 0; i < lastName.length(); i++) {
                if (!Character.isLetter(lastName.charAt(i))) {
                    throw new InvalidException("A name can only contain letters");
                }
            }
        }
        this.lastName = lastName;
    }

    //Throws an exception if the name has digits in it
    public void setMiddleInitial(char middleInitial) {
        if (!Character.isWhitespace(middleInitial)) {
            if (!Character.isLetter(middleInitial)) {
                throw new InvalidException("A middle initial can only be a letter");
            }
        }
        this.middleInitial = middleInitial;
    }

    //converts everything into a formatted toString
    @Override
    public String toString() {
        return String.format("%s,%s %s", this.lastName, this.firstName, this.middleInitial);
    }

    public void convert(String line) {
        this.lastName = line.substring(0, line.indexOf(','));
        this.firstName = line.substring(line.indexOf(',') + 1, line.indexOf(' ', line.indexOf(',')));
        this.middleInitial = line.substring(line.length() - 1, line.length()).charAt(0);
    }
}
