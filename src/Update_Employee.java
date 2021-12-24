import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Update_Employee extends DBConnection implements ActionListener {
    JFrame frame = new JFrame("Update Employee");
    JLabel l1, l2, l3, l20, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    JPanel p1;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    JButton b1, b2, b3;
    TextArea ta;

    Update_Employee() {

        frame.setVisible(true);
        frame.setBounds(0, 0, 1024, 735);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("");
        l1.setBounds(0, 0, 1024, 735);
        l1.setOpaque(true);
        l1.setBackground(new Color(204, 153, 255));
        frame.add(l1);

        p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(100, 0, 824, 635);
        p1.setLayout(null);
        l1.add(p1);

        l2 = new JLabel("");
        l2.setBackground(new Color(102, 0, 153));
        l2.setBounds(0, 0, 824, 135);
        l2.setOpaque(true);
        p1.add(l2);

        l3 = new JLabel("Update Employee Details", JLabel.CENTER);
        l2.add(l3);
        l3.setBounds(0, 0, 824, 50);
        l3.setForeground(Color.white);
        l3.setFont(new Font("serif", Font.BOLD, 30));

        l20 = new JLabel("Employee ID");
        l20.setForeground(Color.white);
        l20.setFont(new Font("serif", Font.BOLD, 25));
        l20.setBounds(170, 70, 200, 30);
        l2.add(l20);

        t1 = new JTextField(25);
        t1.setBounds(320, 70, 200, 30);
        t1.setFont(new Font("serif", Font.BOLD, 20));
        l2.add(t1);

        b1 = new JButton("Search");
        b1.setBounds(550, 70, 100, 40);
        l2.add(b1);
        b1.addActionListener(this);

        Font font1 = new Font("serif", Font.BOLD, 20);
        l4 = new JLabel("Full Name");
        l4.setFont(font1);
        l4.setBounds(50, 150, 100, 30);
        p1.add(l4);

        l5 = new JLabel("Age");
        l5.setFont(font1);
        l5.setBounds(50, 200, 100, 30);
        p1.add(l5);

        l6 = new JLabel("Gender");
        l6.setFont(font1);
        l6.setBounds(50, 250, 100, 30);
        p1.add(l6);
        l7 = new JLabel("Birth Date");
        l7.setFont(font1);
        l7.setBounds(50, 300, 100, 30);
        p1.add(l7);

        l8 = new JLabel("Mobile NO.");
        l8.setFont(font1);
        l8.setBounds(50, 350, 100, 30);
        p1.add(l8);

        l9 = new JLabel("Address");
        l9.setFont(font1);
        l9.setBounds(50, 400, 100, 30);
        p1.add(l9);

        l10 = new JLabel("ID");
        l10.setFont(font1);
        l10.setBounds(450, 150, 100, 30);
        p1.add(l10);

        l11 = new JLabel("Post");
        l11.setFont(font1);
        l11.setBounds(450, 200, 100, 30);
        p1.add(l11);

        l12 = new JLabel("Salary");
        l12.setFont(font1);
        l12.setBounds(450, 250, 100, 30);
        p1.add(l12);

        l13 = new JLabel("Experience");
        l13.setFont(font1);
        l13.setBounds(450, 300, 100, 30);
        p1.add(l13);

        l14 = new JLabel("Join Date");
        l14.setFont(font1);
        l14.setBounds(450, 350, 100, 30);
        p1.add(l14);

        l15 = new JLabel("Education");
        l15.setFont(font1);
        l15.setBounds(450, 400, 100, 30);
        p1.add(l15);

        l16 = new JLabel("Email ID");
        l16.setFont(font1);
        l16.setBounds(450, 450, 100, 30);
        p1.add(l16);


        t2 = new JTextField("");
        t2.setFont(font1);
        t2.setBounds(170, 150, 200, 30);
        p1.add(t2);

        t12 = new JTextField("");
        t12.setFont(font1);
        t12.setBounds(170, 200, 200, 30);
        p1.add(t12);
        t3 = new JTextField("");
        t3.setFont(font1);
        t3.setBounds(170, 250, 200, 30);
        p1.add(t3);

        t4 = new JTextField("");
        t4.setFont(font1);
        t4.setBounds(170, 300, 200, 30);
        p1.add(t4);

        t13 = new JTextField("");
        t13.setFont(font1);
        t13.setBounds(170, 350, 200, 30);
        p1.add(t13);

        ta = new TextArea(" ", 100, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setFont(font1);
        ta.setBounds(170, 400, 200, 100);
        p1.add(ta);

        t5 = new JTextField("");
        t5.setFont(font1);
        t5.setBounds(570, 150, 200, 30);
        p1.add(t5);

        t6 = new JTextField("");
        t6.setFont(font1);
        t6.setBounds(570, 200, 200, 30);
        p1.add(t6);

        t7 = new JTextField("");
        t7.setFont(font1);
        t7.setBounds(570, 250, 200, 30);
        p1.add(t7);

        t8 = new JTextField("");
        t8.setFont(font1);
        t8.setBounds(570, 300, 200, 30);
        p1.add(t8);

        t9 = new JTextField("");
        t9.setFont(font1);
        t9.setBounds(570, 350, 200, 30);
        p1.add(t9);

        t10 = new JTextField("");
        t10.setFont(font1);
        t10.setBounds(570, 400, 200, 30);
        p1.add(t10);

        t11 = new JTextField("");
        t11.setFont(font1);
        t11.setBounds(570, 450, 200, 30);
        p1.add(t11);

        ImageIcon img2 = new ImageIcon("add2.jpg");
        Image i2 = img2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(i2);
        b2 = new JButton("Update", img2);
        b2.setBounds(250, 530, 120, 40);
        p1.add(b2);
        b2.addActionListener(this);
        b2.setMnemonic('u');

        ImageIcon img3 = new ImageIcon("logout2.jpg");
        Image i3 = img3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img3 = new ImageIcon(i3);
        b3 = new JButton("Cancel", img3);
        b3.setBounds(450, 530, 120, 40);
        p1.add(b3);
        b3.addActionListener(this);
        b3.setMnemonic('c');

        b2.setToolTipText("Click to Update (Alt+u)");
        b3.setToolTipText("Click to Cancel (Alt+c)");
    }

    public void actionPerformed(ActionEvent e) {
        String s = t1.getText();
        try {
            if (e.getSource() == b1) {
                PreparedStatement st1 = con.prepareStatement("select *from employee where id=?");
                st1.setString(1, s);
                ResultSet rs = st1.executeQuery();
                if (rs.next()) {
                    t2.setText(rs.getString(1));
                    t5.setText(rs.getString(2));
                    t12.setText(rs.getString(3));
                    t6.setText(rs.getString(4));
                    t4.setText(rs.getString(5));
                    t3.setText(rs.getString(6));
                    ta.setText(rs.getString(7));
                    t13.setText(rs.getString(8));
                    t11.setText(rs.getString(9));
                    t10.setText(rs.getString(10));
                    t9.setText(rs.getString(11));
                    t7.setText(rs.getString(12));
                    t8.setText(rs.getString(13));
                } else {
                    JOptionPane.showMessageDialog(null, "Id not found");
                }
            }

            if (e.getSource() == b2) {

                String edu = t10.getText();
                String str2 = "update employee set name=?,id=?,age=?,post=?,bdate=?,gender=?,address=?,mobile=?,email=?,education=?,jdate=?,salary=?,exp=? where id=?";

                String a1 = t2.getText();
                String a2 = t5.getText();
                String a3 = t12.getText();
                String a4 = t6.getText();
                String a5 = t4.getText();
                String a6 = t3.getText();
                String a7 = ta.getText();
                String a8 = t13.getText();
                String a9 = t11.getText();
                String a10 = edu;
                String a11 = t9.getText();
                String a12 = t7.getText();
                String a13 = t8.getText();

                PreparedStatement st2 = con.prepareStatement(str2);
                st2.setString(1, a1);
                st2.setString(2, a2);
                st2.setString(3, a3);
                st2.setString(4, a4);
                st2.setString(5, a5);
                st2.setString(6, a6);
                st2.setString(7, a7);
                st2.setString(8, a8);
                st2.setString(9, a9);
                st2.setString(10, a10);
                st2.setString(11, a11);
                st2.setString(12, a12);
                st2.setString(13, a13);

                st2.setString(14, s);

                st2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update Successfully");
                new Menu();
                frame.setVisible(false);
            }

            if (e.getSource() == b3) {
                new Menu();
                frame.setVisible(false);
            }
        } catch (Exception ae) {
            System.out.println(ae.getMessage());
        }
    }
}
