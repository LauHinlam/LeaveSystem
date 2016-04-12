import Staffs.Employee;
import Staffs.Staff;

import GUI.TreeView;
import Tools.Date;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by JerryLau on 12/4/2016.
 */
public class LeaveSystemApplication extends JPanel implements ActionListener {
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String LEAVE_COMMAND = "leave";
    private static String MESSAGE_COMMAND = "messages";
    private TreeView staffStructure;

    public LeaveSystemApplication() {
        super(new BorderLayout());

        InitTree();
        staffStructure.setPreferredSize(new Dimension(300, 150));
        add(staffStructure, BorderLayout.CENTER);
        JPanel panel = InitLayout();
        add(panel, BorderLayout.SOUTH);
    }

    public void InitTree() {
        staffStructure = new TreeView("Director");
    }

    public JPanel InitLayout() {
        JPanel panel = new JPanel(new GridLayout(0, 3));

        JButton add = newButton("Add", ADD_COMMAND);
        JButton rmv = newButton("Remove", REMOVE_COMMAND);
        JButton lev = newButton("Leave", LEAVE_COMMAND);
        JButton msg = newButton("Message", MESSAGE_COMMAND);

        panel.add(add);
        panel.add(rmv);
        panel.add(lev);
        panel.add(msg);

        return panel;
    }

    public JButton newButton(String text, String command) {
        JButton b = new JButton(text);
        b.setActionCommand(command);
        b.addActionListener(this);
        return b;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals(ADD_COMMAND)) {
            String name = JOptionPane.showInputDialog("Input staff's name");
            Staff s = (Staff) staffStructure.getSelectedNode().getUserObject();
            Employee emp =  new Employee(name, s);
            staffStructure.addNode(emp);
        }
        else if (command.equals(REMOVE_COMMAND)) {
            staffStructure.RemoveCurrentNode();
        }
        else if (command.equals(LEAVE_COMMAND)) {
            DefaultMutableTreeNode node = staffStructure.getSelectedNode();
            if (staffStructure.isRoot(node)) {
                JOptionPane.showMessageDialog(null, "Sorry, you are the Director, you cannot leave.");
                return;
            }
            Date leaveStart = Date.DateInput("Date To Leave(In dd/MM/YYYY format)");
            Date leaveEnd = Date.DateInput("Date To Return(In dd/MM/YYYY format)");
            ((Employee)node.getUserObject()).RequestALeave(leaveStart, leaveEnd);
        }
        else if (command.equals(MESSAGE_COMMAND)) {
            Staff stf = (Staff) staffStructure.getSelectedNode().getUserObject();
            stf.ProcessRequest();
        }
    }

    private static void LeaveSystem() {
        JFrame frame = new JFrame("Staffs Leave System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LeaveSystemApplication newContentPane = new LeaveSystemApplication();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LeaveSystem();
            }
        });
    }
}
