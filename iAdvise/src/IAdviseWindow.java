
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IAdviseWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    public static Student STUDENT = new Student();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JMenu file = new JMenu("File");
    JMenuBar bar = new JMenuBar();
    String input = "";
    int counterView = 0;

    //creating the main window for the program with menu bars and the
    //ability to have tabbed windows in the program itself
    public IAdviseWindow() {
        
        super("iAdvise");
        file.setMnemonic('F');
        JMenuItem newItem = new JMenuItem("Exit");
        newItem.setMnemonic('E');
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //the menu will come from the file menu bar and will allow
        //the user to obtain the student details by entering the
        //students ID number correctly. On entering the ID correctly
        //the program will open up a new tab or the Student.
        JMenuItem item = new JMenuItem("View Students Details");
        item.setMnemonic('V');
        item.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                input = JOptionPane.showInputDialog("Enter Student Id to Displayed:");
                System.out.println(input);
                if (counterView == 0) {
                    tabbedPane.addTab("View Student", new ViewStudentPanel(input));
                } else {
                    new ViewStudentPanel(input);
                }
            }
        });
        
        //this menu bar is going to come from the file menu bar that
        //will allow the user to edit the student information that was
        //entered in before. This is using the Student's ID number to 
        //be entered in correctly. This will allow the program to then
        //open another tab of the student's info ready to be editited
        file.add(item);
        JMenuItem itemEdit = new JMenuItem("Edit Students Details");
        itemEdit.setMnemonic('E');
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = JOptionPane.showInputDialog("Enter Student Id to Displayed:");
                System.out.println(input);
                tabbedPane.addTab("Edit Student", new EditStudentPanel(input));
                

            }
        });
        file.add(itemEdit);
        setJMenuBar(bar);
        bar.add(file);
        file.add(newItem);
        file.add(newItem);
        setSize(WIDTH, HEIGHT);
        setLocation(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        bar.add(file);
        tabbedPane.addTab("Add Student", new AddStudentPanel());
        add(tabbedPane);
        pack();

    }
}
