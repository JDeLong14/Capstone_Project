
import java.util.ArrayList;
import java.io.Serializable;

public class Student implements Serializable {

    private Name name;
    private String id;
    private String gpa;
    private String homeCampus;
    private String major;
    private Address homeAddress;
    private PhoneNumber homePhone;
    private PhoneNumber cellPhone;
    private EmailAddress email;
    private ArrayList<String> currentCourses = new ArrayList<String>();
    private ArrayList<String> completedCourses = new ArrayList<String>();
    private ArrayList<String> requiredCourses = new ArrayList<String>();
    private ArrayList<String> notes = new ArrayList<String>();

    public Student() {
        this(new Name(), "N/A", "N/A", "N/A", "N/A", new Address(), new PhoneNumber(),
                new PhoneNumber(), new EmailAddress());
    }

    public Student(Name name, String id, String gpa, String homeCampus, String major, Address homeAddress,
            PhoneNumber homePhone, PhoneNumber cellPhone, EmailAddress email) {

        this.name = new Name(name);
        this.id = id;
        this.gpa = gpa;
        this.homeCampus = homeCampus;
        this.major = major;
        this.homeAddress = new Address(homeAddress);
        this.homePhone = new PhoneNumber(homePhone);
        this.cellPhone = new PhoneNumber(cellPhone);
        this.email = new EmailAddress(email);
    }

    //gather up the setters and getters
    public void setfName(String fNameLabel) {

        name.setFirstName(fNameLabel);
    }

    public Name getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getGpa() {
        return this.gpa;
    }

    public String getHomeCampus() {
        return this.homeCampus;
    }

    public String getMajor() {
        return this.major;
    }

    public Address getHomeAddress() {
        return this.homeAddress;
    }

    public PhoneNumber getHomePhoneNumber() {
        return this.homePhone;
    }

    public PhoneNumber getCellPhoneNumber() {
        return this.cellPhone;
    }

    public EmailAddress getEmailAddress() {
        return this.email;
    }

    public ArrayList<String> getCurrentCourses() {
        return this.currentCourses;
    }

    public ArrayList<String> getCompletedCourses() {
        return this.completedCourses;
    }

    public ArrayList<String> getRequiredCourses() {
        return this.requiredCourses;
    }

    public ArrayList<String> getNotes() {
        return this.notes;
    }

    //throws an exception if the ID is not 8 digits
    public void setId(String id) {
         if (id.length() != 8) {
            throw new InvalidException("Id has to be 8 digits");
        }
        this.id = id;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public void setHomeCampus(String homeCampus) {
        this.homeCampus = homeCampus;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
