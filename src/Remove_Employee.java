import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Remove_Employee extends DBConnection implements ActionListener {
    JFrame frame = new JFrame("Remove Employee");
    JLabel l1, l2, l3;
    JPanel p1;
    JTextField t1;
    JButton b1, b2;

    Remove_Employee() {
        frame.setVisible(true);
        frame.setBounds(0, 0, 1024, 735);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon img = new ImageIcon("Frontback.jpeg");
        Image i1 = img.getImage().getScaledInstance(1024, 735, Image.SCALE_SMOOTH);
        img = new ImageIcon(i1);
        l1 = new JLabel(img);
        l1.setBounds(0, 0, 1024, 735);
        frame.add(l1);

        l3 = new JLabel("Remove Employee Details");
        l3.setFont(new Font("serif", Font.PLAIN, 60));
        l3.setBounds(230, 20, 1024, 80);
        l1.add(l3);
        l3.setForeground(Color.black);
        l2 = new JLabel("Employee ID", JLabel.CENTER);
        l2.setFont(new Font("serif", Font.BOLD, 30));
        l2.setBounds(300, 290, 370, 35);
        l2.setForeground(Color.black);
        l1.add(l2);

        t1 = new JTextField(20);
        t1.setBounds(390, 360, 200, 30);
        t1.setFont(new Font("serif", Font.BOLD, 20));
        l1.add(t1);

        b1 = new JButton("Remove");
        b1.setBounds(350, 410, 100, 50);
        b1.setFont(new Font("serif", Font.PLAIN, 20));
        l1.add(b1);
        b1.addActionListener(this);
        b1.setMnemonic('r');
        b2 = new JButton("Cancel");
        b2.setBounds(500, 410, 100, 50);
        b2.setFont(new Font("serif", Font.PLAIN, 20));
        l1.add(b2);
        b2.addActionListener(this);
        b2.setMnemonic('c');

        b1.setToolTipText("Click to remove (Alt+r)");
        b2.setToolTipText("Click to cancel (Alt+c)");
    }

    public void actionPerformed(ActionEvent e) {
        String s = t1.getText();
        try {
            if (e.getSource() == b1) {
                String str = "delete from employee where id =?";
                PreparedStatement st = con.prepareStatement(str);
                st.setString(1, s);

                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
                t1.setText(" ");
                new Menu();
                frame.setVisible(false);
            } else {
                new Menu();
                frame.setVisible(false);
            }
        } catch (Exception ae) {
            System.out.println(ae.getMessage());
        }
    }
}
