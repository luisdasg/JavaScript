package javaapplication5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Javaapplication5 {
    public static JFrame f;
    public static JPanel p1;
    public static JLabel l1;
    public static JLabel l2;
    public static JLabel l3;
    public static JLabel l4;
    public static JLabel l5;
    public static JLabel l6;
    public static JLabel letters;
    public static JTextField n1;
    public static JTextField n2;
    public static JTextField n3;
    public static JTextField n4;
    public static JTextField n5;
    public static JTextField n6;
    public static JButton b1;
    public static JButton b2;
    public static void main(String[] args) {
        f=new JFrame("Travel App - ver 1.0");
        Image icon=Toolkit.getDefaultToolkit().getImage("icon.png");
        f.setIconImage(icon);
        p1=new JPanel();
        p1.setLayout(null);
        l1=new JLabel("Miles to Drive: ");
        l2=new JLabel("Mile per Gallon: ");
        l3=new JLabel("Gasoline Price: ");
        l4=new JLabel("Parking Cost: ");
        l5=new JLabel("Tolls Cost: ");
        l6= new JLabel("Result: ");
        n1= new JTextField(15);
        n2=new JTextField(15);
        n3=new JTextField(15);
        n4=new JTextField(15);
        n5=new JTextField(15);
        n6=new JTextField(15);
        b1=new JButton("Calculate");
        b2=new JButton("Clear");
        b1.addActionListener(new Calculations());
        letters = new JLabel("TRAVEL COST APP");
        letters.setBounds(60, 10, 150, 30);
        letters.setFont(new Font("Arial", Font.BOLD, 14));
        letters.setForeground(Color.BLUE);
        l1.setBounds(40, 40, 150, 30);
        l2.setBounds(30, 80, 150, 30);
        l3.setBounds(30, 120, 150, 30);
        l4.setBounds(40, 160, 150, 30);
        l5.setBounds(55, 200, 150, 30);
        l6.setBounds(80, 300, 150, 30);
        n1.setBounds(120, 40, 150, 30);
        n2.setBounds(120, 80, 150, 30);
        n3.setBounds(120, 120, 150, 30);
        n4.setBounds(120, 160, 150, 30);
        n5.setBounds(120, 200,150, 30);
        n6.setBounds(120, 300, 150, 30);
        n6.setBackground(Color.GREEN);
        b1.setBounds(40, 240, 150, 30);
        b2.setBounds(200, 240, 150, 30);
        b2.addActionListener(new Clear());
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(n1);
        p1.add(n2);
        p1.add(n3);
        p1.add(n4);
        p1.add(n5);
        p1.add(n6);
        p1.add(b1);
        p1.add(b2);
        p1.add(letters);
        f.add(p1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(450, 400);
        f.setResizable(false);
        f.setVisible(true);
    }
    public static class Calculations implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            double mtd=Double.parseDouble(n1.getText());
            double mpg=Double.parseDouble(n2.getText());
            double gp=Double.parseDouble(n3.getText());
            double pc=Double.parseDouble(n4.getText());
            double tc=Double.parseDouble(n5.getText());
            TravelCost t=new TravelCost(mtd, mpg, gp, tc, pc);
            t.CalCost();
            n6.setText(""+t.getTotalCost());
        }
        
    }
    public static class Clear implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            n1.setText("");
            n2.setText("");
            n3.setText("");
            n4.setText("");
            n5.setText("");
            n6.setText("");
        }
        
    }
   
   
}
