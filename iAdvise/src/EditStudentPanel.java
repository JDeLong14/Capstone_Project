
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class EditStudentPanel extends JPanel {

    public static String[] campuses = {"Ammerman", "Grant", "East"};
    public static String[] majors = {"Computer Science", "Networking", "CIS", "Web", "Other"};
    public static String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
        "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI",
        "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND",
        "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA",
        "WA", "WV", "WI", "WY"};
    String courses[] = {"CST111", "CST112", "CST121", "CST141", "CST142", "CST205", "CST222",
        "CST242", "CST246", "MAT141", "MAT142", "MAT205"};
    private static final long serialVersionUID = 1L;
    private JLabel addressLabel;
    private JLabel fNameLabel;
    private JLabel mInitialLabel;
    private JLabel lNameLabel;
    private JLabel idLabel;
    private JLabel gpaLabel;
    private JLabel homeCampusLabel;
    private JLabel majorLabel;
    private JLabel homePhoneLabel;
    private JLabel cellPhoneLabel;
    private JLabel emailLabel;
    private JLabel streetNumberLabel;
    private JLabel streetLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel zipLabel;
    private JTextField fNameField;
    private JTextField mInitialField;
    private JTextField lNameField;
    private JTextField idField;
    private JTextField gpaField;
    private JTextField homePhoneField;
    private JTextField cellPhoneField;
    private JTextField emailField;
    private JTextField streetNumberField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField zipField;
    private JLabel coursetaken;
    private JLabel courseRequired;
    private JLabel courseCompleted;
    private JButton submitButton;
    private JComboBox homeCampusBox;
    private JComboBox majorBox;
    private JComboBox stateBox;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel centerCenterPanel;
    private JLabel topLabel;
    private JLabel noteLabel;
    private JLabel errorLabel;
    private JList coursesTaken;
    private JList coursesRequired;
    private JList coursesCompleted;
    static Writer writer = null;
    private JTextField notes;

    //creating the editstudentpanel
    public EditStudentPanel(String studentId) {
        setLayout(new BorderLayout());

        buildTopPanel();
        buildCenterPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        readInputs(studentId);
    }

    //reading the inputs from the file name that was created in
    //the student folder by student ID
    private void readInputs(String studentId) {
        // TODO Auto-generated method stub
        String adress = "";
        String telephone = "";
        String phone = "";
        String filename = "";
        String name = "";
        if (!studentId.equalsIgnoreCase("")) {
            filename = "Student/" + studentId + ".txt";
        } else {
            filename = "";
        }
        File file = new File(filename);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.indexOf("Name") >= 0) {
                    name = line;
                } else if (line.indexOf("ID") >= 0) {
                    idField.setText(line.split("\\:")[1]);
                } else if (line.indexOf("Gpa") >= 0) {
                    gpaField.setText(line.split("\\:")[1]);
                } else if (line.indexOf("Home Number") >= 0) {
                    telephone = line;
                } else if (line.indexOf("Cell Number") >= 0) {
                    phone = line;
                } else if (line.indexOf("E-mail") >= 0) {
                    emailField.setText(line.split("\\:")[1]);
                } else if (line.indexOf("Address") >= 0) {
                    adress = line;
                } else if (line.indexOf("Major") >= 0) {
                    for (int i = 0; i < campuses.length; i++) {
                        if (majors[i].equalsIgnoreCase(line.split("\\:")[1]));
                        this.majorBox.setSelectedItem(majors[i]);
                    }
                } else if (line.indexOf("Campus") >= 0) {
                    for (int i = 0; i < campuses.length; i++) {
                        if (campuses[i].equalsIgnoreCase(line.split("\\:")[1])) {
                            this.homeCampusBox.setSelectedItem(campuses[i]);
                        }
                    }
                } else if (line.indexOf("Notes") >= 0) {
                    notes.setText(line.split("\\:")[1]);
                }

            }

            Name name2 = new Name();
            name2.convert(name.split("\\:")[1]);
            fNameField.setText(name2.getFirstName());
            lNameField.setText(name2.getLastName());
            Address address = new Address();
            address.Convert(adress.split("\\:")[1]);
            streetField.setText(address.getStreet());
            streetNumberField.setText(address.getStreetNumber());
            streetField.setText(address.getStreet());
            cityField.setText(address.getCity());
            zipField.setText(address.getZip());
            for (int i = 0; i < states.length; i++) {
                if (states[i].equalsIgnoreCase(address.getState())) {
                    this.stateBox.setSelectedItem(campuses[i]);
                }
            }
            PhoneNumber number = new PhoneNumber();
            number.convert(phone.split("\\:")[1]);
            cellPhoneField.setText(number.getPhoneNumber());
            PhoneNumber numb = new PhoneNumber();
            numb.convert(telephone.split("\\:")[1]);
            System.out.println(numb.getPhoneNumber());
            homePhoneField.setText(numb.getPhoneNumber());
        } catch (Exception exception) {
        }

    }

    //building the topPannel
    private void buildTopPanel() {
        topPanel = new JPanel();
        topLabel = new JLabel("Please Enter Information in All The Fields.");
        errorLabel = new JLabel();

        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        topPanel.add(topLabel, g);
        g.gridx = 0;
        g.gridy = 1;
        topPanel.add(errorLabel, g);
    }

    //building the centerPanel
    private void buildCenterPanel() {
        buildCenterCenterPanel();

        JScrollPane scroll = new JScrollPane(centerCenterPanel);
        Border border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        scroll.setBorder(border);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(scroll, BorderLayout.CENTER);

    }

    //building the Very centerPanel
    private void buildCenterCenterPanel() {

        //creating the JFrames
        centerCenterPanel = new JPanel();
        fNameLabel = new JLabel("First Name:");
        mInitialLabel = new JLabel("Middle Initial:");
        lNameLabel = new JLabel("Last Name:");
        idLabel = new JLabel("Student ID:");
        gpaLabel = new JLabel("GPA:");
        homeCampusLabel = new JLabel("Home Campus:");
        majorLabel = new JLabel("Major:");
        homePhoneLabel = new JLabel("Home Phone:");
        cellPhoneLabel = new JLabel("Cell Phone:");
        emailLabel = new JLabel("Email:");
        addressLabel = new JLabel("Address:");
        streetNumberLabel = new JLabel("House Number:");
        streetLabel = new JLabel("Street:");
        cityLabel = new JLabel("City:");
        stateLabel = new JLabel("State:");
        zipLabel = new JLabel("Zip Code:");
        coursetaken = new JLabel("Courses Taken:");
        courseRequired = new JLabel("Courses Required:");
        courseCompleted = new JLabel("Courses Completed:");
        coursesTaken = new JList(courses);
        coursesRequired = new JList(courses);
        coursesCompleted = new JList(courses);
        noteLabel = new JLabel("Notes:");

        //setting up the text fields
        fNameField = new JTextField(15);
        mInitialField = new JTextField(15);
        lNameField = new JTextField(15);
        idField = new JTextField(15);
        gpaField = new JTextField(15);
        homePhoneField = new JTextField(15);
        cellPhoneField = new JTextField(15);
        emailField = new JTextField(15);
        homeCampusBox = new JComboBox(campuses);
        notes = new JTextField(30);
        majorBox = new JComboBox(majors);
        streetNumberField = new JTextField(15);
        streetField = new JTextField(15);
        cityField = new JTextField(15);
        zipField = new JTextField(15);
        stateBox = new JComboBox(AddStudentPanel.states);
        
        //setting up the save button and adding a botton listener for it
        //to react to a click of a mouse
        submitButton = new JButton("Save");
        this.submitButton.addActionListener(new EditStudentPanel.ButtonListener());

        //creating the GridBag
        centerCenterPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        // left box
        g.gridx = 0;
        g.gridy = 0;
        g.insets = new Insets(2, 2, 2, 2);
        g.anchor = GridBagConstraints.EAST;
        centerCenterPanel.add(fNameLabel, g);
        g.gridx = 0;
        g.gridy = 1;
        centerCenterPanel.add(mInitialLabel, g);
        g.gridx = 0;
        g.gridy = 2;
        centerCenterPanel.add(lNameLabel, g);
        g.gridx = 0;
        g.gridy = 3;
        centerCenterPanel.add(idLabel, g);
        g.gridx = 0;
        g.gridy = 4;
        centerCenterPanel.add(gpaLabel, g);
        g.gridx = 0;
        g.gridy = 5;
        centerCenterPanel.add(homeCampusLabel, g);
        g.gridx = 0;
        g.gridy = 6;
        centerCenterPanel.add(majorLabel, g);
        g.gridx = 5;
        g.gridy = 5;
        centerCenterPanel.add(homePhoneLabel, g);
        g.gridx = 5;
        g.gridy = 6;
        centerCenterPanel.add(cellPhoneLabel, g);
        g.gridx = 0;
        g.gridy = 9;
        centerCenterPanel.add(emailLabel, g);
        g.gridx = 5;
        g.gridy = 0;
        centerCenterPanel.add(streetNumberLabel, g);
        g.gridx = 5;
        g.gridy = 1;
        centerCenterPanel.add(streetLabel, g);
        g.gridx = 5;
        g.gridy = 2;
        centerCenterPanel.add(cityLabel, g);
        g.gridx = 5;
        g.gridy = 3;
        centerCenterPanel.add(stateLabel, g);
        g.gridx = 5;
        g.gridy = 4;
        centerCenterPanel.add(zipLabel, g);
        g.gridx = 0;
        g.gridy = 10;
        g.anchor = GridBagConstraints.CENTER;
        centerCenterPanel.add(coursetaken, g);
        g.gridx = 0;
        g.gridy = 11;
        centerCenterPanel.add(coursesTaken, g);
        g.gridx = 3;
        g.gridy = 10;
        centerCenterPanel.add(courseRequired, g);
        g.gridx = 3;
        g.gridy = 11;
        centerCenterPanel.add(coursesRequired, g);
        g.gridx = 6;
        g.gridy = 10;
        centerCenterPanel.add(courseCompleted, g);
        g.gridx = 6;
        g.gridy = 11;
        centerCenterPanel.add(coursesCompleted, g);
        g.gridx = 2;
        g.gridy = 15;
        centerCenterPanel.add(noteLabel, g);

        // right box
        g.gridx = 1;
        g.gridy = 0;
        g.anchor = GridBagConstraints.WEST;
        centerCenterPanel.add(fNameField, g);
        g.gridx = 1;
        g.gridy = 1;
        centerCenterPanel.add(mInitialField, g);
        g.gridx = 1;
        g.gridy = 2;
        centerCenterPanel.add(lNameField, g);
        g.gridx = 1;
        g.gridy = 3;
        centerCenterPanel.add(idField, g);
        g.gridx = 1;
        g.gridy = 4;
        centerCenterPanel.add(gpaField, g);
        g.gridx = 1;
        g.gridy = 5; 
        g.anchor = GridBagConstraints.CENTER;
        centerCenterPanel.add(homeCampusBox, g);
        g.gridx = 1;
        g.gridy = 6;
        centerCenterPanel.add(majorBox, g);
        g.gridx = 6;
        g.gridy = 5;
        centerCenterPanel.add(homePhoneField, g);
        g.gridx = 6;
        g.gridy = 6;
        centerCenterPanel.add(cellPhoneField, g);
        g.gridx = 1;
        g.gridy = 9;
        centerCenterPanel.add(emailField, g);
        g.gridx = 6;
        g.gridy = 0;
        centerCenterPanel.add(streetNumberField, g);
        g.gridx = 6;
        g.gridy = 1;
        centerCenterPanel.add(streetField, g);
        g.gridx = 6;
        g.gridy = 2;
        centerCenterPanel.add(cityField, g);
        g.gridx = 6;
        g.gridy = 3;
        centerCenterPanel.add(stateBox, g);
        g.gridx = 6;
        g.gridy = 4;
        centerCenterPanel.add(zipField, g);
        g.gridx = 3;
        g.gridy = 15;
        centerCenterPanel.add(notes, g);
        g.gridx = 3;
        g.gridy = 16;
        g.anchor = GridBagConstraints.CENTER;
        centerCenterPanel.add(submitButton, g);
    }

    //A rinse and reapeat buttonlistener compared to the addstudentpanel
    //does the same exact thing as what the other button listener does
    //when someone hits the button
    private class ButtonListener
            implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String fNameLabel = fNameField.getText();
            String LNameLabel = lNameField.getText();
            String middleName = mInitialField.getText();
            String idLabel = idField.getText();
            String gpaLabel = gpaField.getText();
            String homeCampusLabel = (String) homeCampusBox.getSelectedItem();
            String majorsLabel = (String) majorBox.getSelectedItem();
            String homePhoneLabel = homePhoneField.getText();
            String cellPhoneLabel = cellPhoneField.getText();
            String emailLabel = emailField.getText();
            String stateLabel = (String) stateBox.getSelectedItem();
            String streetNumberLabel = streetNumberField.getText();
            String streetLabel = streetField.getText();
            String cityLabel = cityField.getText();
            String zipLabel = zipField.getText();
            String note = notes.getText();
            Object[] coursesT = coursesTaken.getSelectedValues();
            Object[] coursesR = coursesCompleted.getSelectedValues();
            Object[] coursesC = coursesRequired.getSelectedValues();

            try {
                Name name = new Name();
                name.setFirstName(fNameLabel);
                name.setLastName(LNameLabel);
                name.setMiddleInitial(middleName.charAt(0));

                PhoneNumber number = new PhoneNumber();
                number.setPhoneNumber(cellPhoneLabel);

                PhoneNumber numb = new PhoneNumber();
                numb.setPhoneNumber(homePhoneLabel);

                EmailAddress address = new EmailAddress();
                address.setEmail(emailLabel);

                Address add = new Address();
                add.setCity(cityLabel);
                add.setStreet(streetLabel);
                add.setZip(zipLabel);
                add.setStreetNumber(streetNumberLabel);
                add.setState(stateLabel);

                String filename = "Student/" + idLabel + ".txt";
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
                writer.write("Name: " + name.toString());
                writer.write("\n");
                writer.write(" ID: " + idLabel);
                writer.write("\n");
                writer.write(" Gpa: " + gpaLabel);
                writer.write("\n");
                writer.write(" Campus: " + homeCampusLabel);
                writer.write("\n");
                writer.write(" Major: " + majorsLabel + ", ");
                writer.write("\n");

                writer.write(" Home Number: " + numb.toString());
                writer.write("\n");
                writer.write(" Cell Number: " + number.toString());
                writer.write("\n");
                writer.write(" E-mail: " + emailLabel);
                writer.write("\n");
                writer.write(" Address: " + add.toString());
                writer.write("\n");

                writer.write("Courses Completed: ");
                for (int i = 0; i < coursesC.length; i++) {
                    writer.write(" " + coursesC[i].toString());
                }
                writer.write("\n");

                writer.write(" Courses Taken: ");
                for (int i = 0; i < coursesT.length; i++) {
                    writer.write(" " + coursesT[i].toString());
                }
                writer.write("\n");

                writer.write(" Courses Required: ");
                for (int i = 0; i < coursesR.length; i++) {
                    writer.write(" " + coursesR[i].toString());
                }

                writer.write("\n");
                writer.write(" Notes :" + note);
                writer.write("\n");
                JOptionPane optionPane = new JOptionPane("Details Successfully Saved", JOptionPane.INFORMATION_MESSAGE, JOptionPane.CLOSED_OPTION);
                JDialog dialog = optionPane.createDialog(getParent(), "Saved");
                dialog.setVisible(true);
            } catch (Exception exception) {
                System.out.println(exception);
                JOptionPane optionPane = new JOptionPane(exception.getMessage(), JOptionPane.ERROR_MESSAGE, JOptionPane.CLOSED_OPTION);
                JDialog dialog = optionPane.createDialog(getParent(), "Error");
                dialog.setVisible(true);

            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {
                }
            }

        }
    }
}
