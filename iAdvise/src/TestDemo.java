
import java.io.*;

public class TestDemo {

    public static void main(String[] args) throws IOException {
        
    //testing out if the program is working and is running properly.
//        try {
//            Name name = new Name("John", "Smith", ' ');
//            System.out.println(name);
//
//            PhoneNumber homePhone = new PhoneNumber("5463493564");
//            System.out.println(homePhone);
//
//            PhoneNumber cellPhone = new PhoneNumber("7965412345");
//            System.out.println(cellPhone);
//
//            EmailAddress email = new EmailAddress("JavaTestProgram@aol.com");
//            System.out.println(email);
//
//            Address homeAddress = new Address("555", "Flower Crt", "SomeRandomTown", "NY", "34678");
//            System.out.println(homeAddress);
//
//            System.out.println(AddStudentPanel.states.length);
//
//        } catch (InvalidException ie) {
//            System.out.println(ie.getMessage());
//        }

        //creating the new file Directory called Students
        File dir = new File("Student");
        dir.mkdir();

        new IAdviseWindow();


    }
}
