import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Add_Employee extends DBConnection implements ActionListener {
    JFrame frame;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    String[] p = {
            "Manager",
            "Developer",
            "Designer",
            "Tester",
            "Accountant"
    };
    JComboBox jc;
    TextArea ta;
    JPanel p1;
    JRadioButton r1, r2;
    ButtonGroup bg;
    JButton b1, b2;
    JPopupMenu pm;
    JMenuItem n1, n2, n3;

    Add_Employee() {
        frame = new JFrame("Add Employee");
        frame.setBounds(0, 0, 1024, 735);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        l1 = new JLabel("");
        l1.setBackground(new Color(204, 153, 255));
        l1.setBounds(0, 0, 1024, 735);
        l1.setOpaque(true);
        frame.add(l1);

        p1 = new JPanel();
        p1.setFont(new Font("serif", Font.BOLD, 50));
        p1.setBackground(Color.white);
        p1.setBounds(100, 50, 824, 620);
        p1.setLayout(null);
        l1.add(p1);

        l2 = new JLabel("");
        l2.setBackground(new Color(102, 0, 153));
        l2.setBounds(0, 0, 824, 70);
        l2.setOpaque(true);
        p1.add(l2);

        l17 = new JLabel("");
        l17.setBackground(new Color(102, 0, 153));
        l17.setBounds(0, 580, 824, 40);
        l17.setOpaque(true);
        p1.add(l17);

        l3 = new JLabel("Add New Employee Details", JLabel.CENTER);
        l2.add(l3);
        l3.setBounds(0, 0, 824, 50);
        l3.setForeground(Color.white);
        l3.setFont(new Font("serif", Font.BOLD, 30));

        Font font1 = new Font("serif", Font.BOLD, 20);
        l4 = new JLabel("Full Name");
        l4.setFont(font1);
        l4.setBounds(50, 100, 100, 30);
        p1.add(l4);

        l5 = new JLabel("Age");
        l5.setFont(font1);
        l5.setBounds(50, 150, 100, 30);
        p1.add(l5);

        l6 = new JLabel("Gender");
        l6.setFont(font1);
        l6.setBounds(50, 200, 100, 30);
        p1.add(l6);

        l7 = new JLabel("Birth Date");
        l7.setFont(font1);
        l7.setBounds(50, 250, 100, 30);
        p1.add(l7);

        l8 = new JLabel("Mobile NO.");
        l8.setFont(font1);
        l8.setBounds(50, 300, 100, 30);
        p1.add(l8);

        l9 = new JLabel("Address");
        l9.setFont(font1);
        l9.setBounds(50, 350, 100, 30);
        p1.add(l9);

        l10 = new JLabel("ID");
        l10.setFont(font1);
        l10.setBounds(450, 100, 100, 30);
        p1.add(l10);

        l11 = new JLabel("Post");
        l11.setFont(font1);
        l11.setBounds(450, 150, 100, 30);
        p1.add(l11);

        l12 = new JLabel("Salary");
        l12.setFont(font1);
        l12.setBounds(450, 200, 100, 30);
        p1.add(l12);

        l13 = new JLabel("Experience");
        l13.setFont(font1);
        l13.setBounds(450, 250, 100, 30);
        p1.add(l13);

        l14 = new JLabel("Join Date");
        l14.setFont(font1);
        l14.setBounds(450, 300, 100, 30);
        p1.add(l14);

        l15 = new JLabel("Education");
        l15.setFont(font1);
        l15.setBounds(450, 350, 100, 30);
        p1.add(l15);

        l16 = new JLabel("Email ID");
        l16.setFont(font1);
        l16.setBounds(450, 400, 100, 30);
        p1.add(l16);

        t1 = new JTextField("");
        t1.setFont(font1);
        t1.setBounds(170, 100, 200, 30);
        p1.add(t1);

        t2 = new JTextField("");
        t2.setFont(font1);
        t2.setBounds(170, 150, 100, 30);
        p1.add(t2);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        p1.add(r1);
        p1.add(r2);
        r1.setBounds(170, 200, 70, 30);
        r2.setBounds(260, 200, 100, 30);
        t3 = new JTextField("");
        t3.setFont(font1);
        t3.setBounds(170, 250, 200, 30);
        p1.add(t3);

        t4 = new JTextField("");
        t4.setFont(font1);
        t4.setBounds(170, 300, 200, 30);
        p1.add(t4);

        ta = new TextArea(" ", 100, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setFont(font1);
        ta.setBounds(170, 350, 200, 100);
        p1.add(ta);

        t5 = new JTextField("");
        t5.setFont(font1);
        t5.setBounds(570, 100, 200, 30);
        p1.add(t5);

        jc = new JComboBox(p);
        jc.setBounds(570, 150, 200, 30);  //post
        p1.add(jc);

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

        ImageIcon img2 = new ImageIcon("add2.jpg");
        Image i2 = img2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img2 = new ImageIcon(i2);
        b1 = new JButton("Add", img2);
        b1.setBounds(250, 500, 120, 40);
        p1.add(b1);
        b1.addActionListener(this);
        b1.setMnemonic('a');

        ImageIcon img3 = new ImageIcon("logout2.jpg");
        Image i3 = img3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img3 = new ImageIcon(i3);
        b2 = new JButton("Cancel", img3);
        b2.setBounds(450, 500, 120, 40);
        p1.add(b2);
        b2.addActionListener(this);
        b2.setMnemonic('c');

        b1.setToolTipText("Click to add (Alt+a)");
        b2.setToolTipText("Click to cancel (Alt+c)");

        pm = new JPopupMenu("File");
        n1 = new JMenuItem("Clear");
        n2 = new JMenuItem("Go Back");
        pm.add(n1);
        pm.add(n2);
        p1.add(pm);

        p1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pm.show(frame, e.getX(), e.getY());
            }
        });
        n1.addActionListener(this);
        n2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String a1 = t1.getText();
        String a2 = t2.getText();
        String a3 = t3.getText();
        String a4 = t4.getText();
        String a5 = t5.getText();
        String a6 = t6.getText();
        String a7 = t7.getText();
        String a8 = t8.getText();
        String a9 = t9.getText();
        String a10 = t10.getText();
        String a11 = ta.getText();
        String a12;
        String a13 = (String) jc.getSelectedItem();

        if (r1.isSelected()) {
            a12 = "Men";
        } else {
            a12 = "Women";
        }

        if (e.getSource() == b2) {
            new Menu();
            frame.setVisible(false);
        }
        if (e.getSource() == b1) {
            try {

                String q = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(q);
                st.setString(1, a1);
                st.setString(2, a5);
                st.setString(3, a2);
                st.setString(4, a13);
                st.setString(5, a3);
                st.setString(6, a12);
                st.setString(7, a11);
                st.setString(8, a4);
                st.setString(9, a10);
                st.setString(10, a9);
                st.setString(11, a8);
                st.setString(12, a6);
                st.setString(13, a7);

                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                frame.setVisible(false);
                new Menu();
            } catch (Exception ee) {
                System.out.println("The error is:" + ee);
            }
        }
        if (e.getSource() == n1) {
            t1.setText(" ");
            t2.setText(" ");
            t3.setText(" ");
            t4.setText(" ");
            t5.setText(" ");
            t6.setText(" ");
            t7.setText(" ");
            t8.setText(" ");
            t9.setText(" ");
            t10.setText(" ");
            ta.setText(" ");
        }
        if (e.getSource() == n2) {
            new Menu();
            frame.setVisible(false);
        }
    }
}
