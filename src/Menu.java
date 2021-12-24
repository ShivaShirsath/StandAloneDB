import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Menu extends DBConnection implements ActionListener {
    JFrame frame;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JPanel p1;
    JButton b1, b2, b3, b4, b5;


    Menu() {
        frame = new JFrame("Menu");
        frame.setBounds(0, 0, 1024, 735);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        l1 = new JLabel("");
        l1.setBounds(0, 0, 1024, 735);
        l1.setBackground(new Color(204, 153, 255));
        l1.setOpaque(true);
        frame.add(l1);

        p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(100, 100, 824, 520);
        p1.setLayout(null);
        l1.add(p1);

        l2 = new JLabel("");
        l2.setBackground(new Color(102, 0, 153));
        l2.setBounds(0, 0, 824, 70);
        l2.setOpaque(true);
        p1.add(l2);

        l3 = new JLabel("Menu", JLabel.CENTER);
        l2.add(l3);
        l3.setBounds(0, 0, 824, 50);
        l3.setForeground(Color.white);
        l3.setFont(new Font("serif", Font.BOLD, 30));

        ImageIcon img2 = new ImageIcon("add.jpeg");
        Image i2 = img2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(i2);
        b1 = new JButton(img2);
        b1.setBounds(100, 100, 130, 130);
        p1.add(b1);


        ImageIcon img3 = new ImageIcon("remove.jpeg");
        Image i3 = img3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img3 = new ImageIcon(i3);
        b2 = new JButton(img3);
        b2.setBounds(350, 100, 130, 130);
        p1.add(b2);

        ImageIcon img4 = new ImageIcon("search.jpeg");
        Image i4 = img4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img4 = new ImageIcon(i4);
        b3 = new JButton(img4);
        b3.setBounds(600, 100, 130, 130);
        p1.add(b3);

        ImageIcon img5 = new ImageIcon("update.jpeg");
        Image i5 = img5.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img5 = new ImageIcon(i5);
        b4 = new JButton(img5);
        b4.setBounds(220, 300, 130, 130);
        p1.add(b4);

        ImageIcon img6 = new ImageIcon("logout.jpeg");
        Image i6 = img6.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img6 = new ImageIcon(i6);
        b5 = new JButton(img6);
        b5.setBounds(480, 300, 130, 130);
        p1.add(b5);

        Font font2 = new Font("serif", Font.BOLD, 30);
        l4 = new JLabel("Add", JLabel.CENTER);
        l4.setFont(font2);
        l4.setBounds(100, 230, 100, 40);
        p1.add(l4);

        l5 = new JLabel("Remove", JLabel.CENTER);
        l5.setFont(font2);
        l5.setBounds(350, 230, 120, 40);
        p1.add(l5);

        l6 = new JLabel("Search", JLabel.CENTER);
        l6.setFont(font2);
        l6.setBounds(600, 230, 120, 40);
        p1.add(l6);

        l7 = new JLabel("Update", JLabel.CENTER);
        l7.setFont(font2);
        l7.setBounds(220, 430, 120, 40);
        p1.add(l7);

        l8 = new JLabel("LogOut", JLabel.CENTER);
        l8.setFont(font2);
        l8.setBounds(480, 430, 120, 40);
        p1.add(l8);

        b1.addActionListener(this);
        b1.setMnemonic('a');
        b2.addActionListener(this);
        b2.setMnemonic('r');
        b3.addActionListener(this);
        b3.setMnemonic('s');
        b4.addActionListener(this);
        b4.setMnemonic('u');
        b5.addActionListener(this);
        b5.setMnemonic('l');

        b1.setToolTipText("Click to Add (Alt+a)");
        b2.setToolTipText("Click to remove (Alt+r)");
        b3.setToolTipText("Click to search (Alt+s)");
        b4.setToolTipText("Click to update (Alt+u)");
        b5.setToolTipText("Click to logout (Alt+l)");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Add_Employee();
            frame.setVisible(false);
        }
        if (e.getSource() == b2) {
            new Remove_Employee();
            frame.setVisible(false);
        }
        if (e.getSource() == b3) {
            new View_Employee();
            frame.setVisible(false);
        }
        if (e.getSource() == b4) {
            new Update_Employee();
            frame.setVisible(false);
        }
        if (e.getSource() == b5) {
            JOptionPane.showMessageDialog(null, "System Terminated...");
            System.exit(1);
        }
    }
}
