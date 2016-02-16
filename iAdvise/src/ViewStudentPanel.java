
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class ViewStudentPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel gpaLabel;
    private JLabel homeCampusLabel;
    private JLabel majorLabel;
    private JLabel homePhoneLabel;
    private JLabel cellPhoneLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private JLabel currentCoursesLabel;
    private JLabel completedCoursesLabel;
    private JLabel requiredCoursesLabel;
    private JLabel nameDisplayLabel;
    private JLabel idDisplayLabel;
    private JLabel gpaDisplayLabel;
    private JLabel homeCampusDisplayLabel;
    private JLabel majorDisplayLabel;
    private JLabel homePhoneDisplayLabel;
    private JLabel cellPhoneDisplayLabel;
    private JLabel emailDisplayLabel;
    private JLabel addressDisplayLabel;
    private JLabel currentCoursesDisplayLabel;
    private JLabel completedCoursesDisplayLabel;
    private JLabel requiredCoursesDisplayLabel;
    private JLabel notesLabel;

    
    //View the data from the text file, while importing the data
    //the string is getting slipt
    public ViewStudentPanel(String studendId) {

        String filename = "";
        if (!studendId.equalsIgnoreCase("")) {
            filename = "Student/" + studendId + ".txt";
        } else {
            filename = "";
        }
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.indexOf("Name") >= 0) {
                    nameDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("ID") >= 0) {
                    idDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Gpa") >= 0) {
                    gpaDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Campus") >= 0) {
                    homeCampusDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Major") >= 0) {
                    majorDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Home Number") >= 0) {
                    homePhoneDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Cell Number") >= 0) {
                    cellPhoneDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("E-mail") >= 0) {
                    emailDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Address") >= 0) {
                    addressDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Courses Completed") >= 0) {
                    currentCoursesDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Courses Taken") >= 0) {
                    completedCoursesDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Courses Required") >= 0) {
                    requiredCoursesDisplayLabel = new JLabel(line.split("\\:")[1]);
                } else if (line.indexOf("Notes") >= 0) {
                    notesLabel = new JLabel(line);
                }

            }

            //sets up the JFrames
            nameLabel = new JLabel("Name: ");
            idLabel = new JLabel("Student ID: ");
            gpaLabel = new JLabel("GPA: ");
            homeCampusLabel = new JLabel("Home Campus: ");
            majorLabel = new JLabel("Major: ");
            homePhoneLabel = new JLabel("Home Phone: ");
            cellPhoneLabel = new JLabel("Cell Phone: ");
            emailLabel = new JLabel("Email: ");
            addressLabel = new JLabel("Address: ");
            currentCoursesLabel = new JLabel("Current Courses: ");
            completedCoursesLabel = new JLabel("Completed Courses: ");
            requiredCoursesLabel = new JLabel("Requried Courses: ");


            setLayout(new GridBagLayout());
            GridBagConstraints g = new GridBagConstraints();
            // left box.
            g.gridx = 0;
            g.gridy = 0;
            g.insets = new Insets(5, 5, 5, 5);
            add(nameLabel, g);
            g.gridx = 0;
            g.gridy = 1;
            add(idLabel, g);
            g.gridx = 0;
            g.gridy = 2;
            add(gpaLabel, g);
            g.gridx = 0;
            g.gridy = 3;
            add(homeCampusLabel, g);
            g.gridx = 0;
            g.gridy = 4;
            add(majorLabel, g);
            g.gridx = 0;
            g.gridy = 5;
            add(homePhoneLabel, g);
            g.gridx = 0;
            g.gridy = 6;
            add(cellPhoneLabel, g);
            g.gridx = 0;
            g.gridy = 7;
            add(emailLabel, g);
            g.gridx = 0;
            g.gridy = 8;
            add(addressLabel, g);
            g.gridx = 0;
            g.gridy = 9;
            add(currentCoursesLabel, g);
            g.gridx = 0;
            g.gridy = 10;
            add(completedCoursesLabel, g);
            g.gridx = 0;
            g.gridy = 11;
            add(requiredCoursesLabel, g);

            // Right components.
            g.gridx = 1;
            g.gridy = 0;
            add(nameDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 1;
            add(idDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 2;
            add(gpaDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 3;
            add(homeCampusDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 4;
            add(majorDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 5;
            add(homePhoneDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 6;
            add(cellPhoneDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 7;
            add(emailDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 8;
            add(addressDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 9;
            add(currentCoursesDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 10;
            add(completedCoursesDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 11;
            add(requiredCoursesDisplayLabel, g);
            g.gridx = 1;
            g.gridy = 12;
            g.anchor = GridBagConstraints.CENTER;
            add(notesLabel, g);
            
            //posts the data up into the window
            this.repaint();
            this.setVisible(true);

        } catch (FileNotFoundException e) {
        }



    }
}
