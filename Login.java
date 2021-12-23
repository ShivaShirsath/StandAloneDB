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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Login extends DBConnection implements ActionListener {
    JFrame frame;
    JLabel l1, l2, l3, l4, l5;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2;
    JProgressBar jp;
    int i, num = 0;

    Login() {
        frame = new JFrame("Login");
        frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon img = new ImageIcon("Frontback.jpeg");
        Image i1 = img.getImage().getScaledInstance(1024, 735, Image.SCALE_SMOOTH);
        img = new ImageIcon(i1);
        l1 = new JLabel(img);
        l1.setBounds(0, 0, 1024, 735);
        frame.add(l1);
        l1.setLayout(null);

        l2 = new JLabel("Employee Management System");
        l2.setBounds(70, 50, 1024, 80);
        l2.setFont(new Font("serif", Font.PLAIN, 70));
        l1.add(l2);
        //login controls
        Font font = new Font("serif", Font.BOLD, 30);
        l3 = new JLabel("Username");
        l4 = new JLabel("Password");
        l3.setBounds(320, 350, 150, 40);
        l3.setFont(font);
        l3.setForeground(Color.red);
        l4.setBounds(320, 400, 150, 40);
        l4.setFont(font);
        l4.setForeground(Color.red);
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        t1.setFont(font);
        t2.setFont(font);
        t1.setBounds(500, 350, 200, 40);
        t2.setBounds(500, 400, 200, 40);

        l1.add(l3);
        l1.add(l4);
        l1.add(t1);
        l1.add(t2);

        b1 = new JButton("Login");
        b1.setMnemonic('l');
        b2 = new JButton("Exit");
        b2.setMnemonic('e');
        b1.setFont(font);
        b2.setFont(font);
        b1.setBounds(320, 500, 150, 50);
        b2.setBounds(520, 500, 150, 50);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setToolTipText("Click to login (Alt+l)");
        b2.setToolTipText("Click to exit (Alt+e)");
        b1.setVisible(false);
        b2.setVisible(false);
        l1.add(b1);
        l1.add(b2);

        jp = new JProgressBar(0, 2000);
        jp.setValue(0);
        jp.setStringPainted(true);
        jp.setVisible(false);
        jp.setBounds(400, 600, 200, 30);
        l1.add(jp);

        l5 = new JLabel("System Starting.....", JLabel.CENTER);
        l5.setVisible(false);
        l5.setBounds(400, 650, 250, 40);
        l5.setFont(font);
        l1.add(l5);
        frame.setBounds(0, 0, 1024, 735);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        iterate();
        b1.setVisible(true);
        b2.setVisible(true);
    }

    public void iterate() {
        jp.setVisible(true);
        l5.setVisible(true);
        while (i <= 2000) {
            jp.setValue(i);
            i = i + 20;
            try {
                Thread.sleep(50); //when we increse number speed will decreases.
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        jp.setVisible(false);
        l5.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            JOptionPane.showMessageDialog(null, "System Terminated...");
            System.exit(1);
        }
        try {
            String u = t1.getText();
            String p = t2.getText();
            String q = "select * from login where username=? and password=?";

            PreparedStatement st = con.prepareStatement(q);

            st.setString(1, u);
            st.setString(2, p);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successfully");
                new Menu();
                frame.setVisible(false);
            } else {
                t1.setText("");
                t2.setText("");
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
