import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class View_Employee extends DBConnection implements ActionListener {
    JFrame frame = new JFrame("View_Employee");
    JLabel l1, l2, l3, l4;
    JTextField t1;
    JButton b1, b2;
    JTable table;
    DefaultTableModel model;
    JScrollPane js;
    String[] s1 = {"Employee Name", "Employee ID", "Age", "Job Post", "BirthDate", "Gender", "Address", "Mobile NO.", "Email ID", "Education", "Join Date", "Salary", "Experience"};

    View_Employee() {
        frame.setVisible(true);
        frame.setBounds(0, 0, 1024, 735);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(255, 255, 255));

        l1 = new JLabel("");
        l1.setBackground(new Color(102, 0, 153));
        l1.setBounds(0, 0, 1024, 735);
        l1.setOpaque(true);
        frame.add(l1);

        ImageIcon img = new ImageIcon("search.jpeg");
        Image i1 = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img = new ImageIcon(i1);
        l4 = new JLabel(img);
        l4.setBounds(100, 10, 100, 100);
        l1.add(l4);

        l2 = new JLabel("View Employee Details", JLabel.CENTER);
        l1.add(l2);
        l2.setBounds(0, 0, 1024, 50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif", Font.BOLD, 30));
        l3 = new JLabel("Employee ID");
        l3.setForeground(Color.white);
        l3.setFont(new Font("serif", Font.BOLD, 25));
        l3.setBounds(270, 70, 200, 30);
        l1.add(l3);

        t1 = new JTextField(25);
        t1.setBounds(420, 70, 200, 30);
        t1.setFont(new Font("serif", Font.BOLD, 20));
        l1.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(650, 70, 100, 40);
        l1.add(b1);
        b1.addActionListener(this);
        b1.setMnemonic('s');
        b2 = new JButton("Cancel");
        b2.setBounds(800, 70, 100, 40);
        l1.add(b2);
        b2.addActionListener(this);
        b2.setMnemonic('c');

        model = new DefaultTableModel(0, 13);
        table = new JTable(model);
        table.setFont(new Font("serif", Font.PLAIN, 20));
        table.setRowHeight(35);
        table.setBackground(Color.white);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        js = new JScrollPane(table);
        js.setBounds(0, 140, 1024, 540);
        model.setColumnIdentifiers(s1);
        l1.add(js);
        insert();
    }

    public void insert() {
        try {
            PreparedStatement st1 = con.prepareStatement("select *from employee");
            ResultSet rs = st1.executeQuery();

            String s = t1.getText();

            while (rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                String s4 = rs.getString(4);
                String s5 = rs.getString(5);
                String s6 = rs.getString(6);
                String s7 = rs.getString(7);
                String s8 = rs.getString(8);
                String s9 = rs.getString(9);
                String s10 = rs.getString(10);
                String s11 = rs.getString(11);
                String s12 = rs.getString(12);
                String s13 = rs.getString(13);

                model.addRow(new Object[]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13});
            }
        } catch (Exception ae) {
            System.out.println(ae.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            new Menu();
            frame.setVisible(false);
        } else {
            try {
                String s = t1.getText();
                model.setRowCount(0);

                PreparedStatement st2 = con.prepareStatement("select *from employee where id=?");
                st2.setString(1, s);
                ResultSet rs = st2.executeQuery();
                while (rs.next()) {
                    String s1 = rs.getString(1);
                    String s2 = rs.getString(2);
                    String s3 = rs.getString(3);
                    String s4 = rs.getString(4);
                    String s5 = rs.getString(5);
                    String s6 = rs.getString(6);
                    String s7 = rs.getString(7);
                    String s8 = rs.getString(8);
                    String s9 = rs.getString(9);
                    String s10 = rs.getString(10);
                    String s11 = rs.getString(11);
                    String s12 = rs.getString(12);
                    String s13 = rs.getString(13);

                    model.addRow(new Object[]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13});
                }
            } catch (Exception ae) {
                System.out.println(ae.getMessage());
            }
        }
    }
}
