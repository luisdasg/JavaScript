package FinalProjectView;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import FinalProjectModel.Employee;
import FinalProjectModel.EmployeeCRUD;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.awt.event.ActionListener;

public class EmployeeGUI extends JFrame{
    public static final int width=410;
    public static final int height=510;
   
    private Employee emp1;
    private Employee emp2;
    private EmployeeCRUD crud= new EmployeeCRUD();
   
    private JTabbedPane tp;
    private JPanel panel1;
    private JPanel panel2;
   
    //components of panel 1(INSERT)
    private JLabel lblTitle;
    private JLabel lblLname;
    private JLabel lblFname;
    private JLabel lblAddress1;
    private JLabel lblAddress2;
    private JLabel lblCity;
    private JLabel lblState;
    private JLabel lblDOB;
    private JLabel lblSalary;
   
    private JTextField txtLname;
    private JTextField txtFname;
    private JTextField txtAddress1;
    private JTextField txtAddress2;
    private JTextField txtCity;
    private JTextField txtState;
    private JTextField txtDOB;
    private JTextField txtSalary;
   
    private JButton btnSave;
    private JButton btnClear;
    
    // components of panel 2 (DELETE)
    
    private JLabel lblTitle2;
    private JLabel lblid2;
    private JLabel lblLname2;
    private JLabel lblFname2;
    private JLabel lblAddress12;
    private JLabel lblAddress22;
    private JLabel lblCity2;
    private JLabel lblState2;
    private JLabel lblDOB2;
    private JLabel lblSalary2;
   
    private JTextField txtid2;
    private JTextField txtLname2;
    private JTextField txtFname2;
    private JTextField txtAddress12;
    private JTextField txtAddress22;
    private JTextField txtCity2;
    private JTextField txtState2;
    private JTextField txtDOB2;
    private JTextField txtSalary2;
   
    private JButton btnSearch;
    private JButton btnDelete;
    private JButton btnClear2;
    public EmployeeGUI()
    {
        super();
        createPanel();
        setFrame();
    }
   
    private void createPanel()
    {
        super.setLayout(null);
        tp=new JTabbedPane();
        panel1=new JPanel(null);
        panel2=new JPanel(null);
        //SETUP PANEL 1
        panel1.setSize(400, 480);
        lblTitle=new JLabel("EMPLOYEE INPUT DATA");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 16));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setBounds(100, 20, 220, 30);
        panel1.add(lblTitle);
       
        lblLname=new JLabel("Last Name: ");
        txtLname=new JTextField(20);
        lblLname.setHorizontalAlignment(JLabel.RIGHT);
        lblLname.setBounds(100, 70, 100, 25);
        txtLname.setBounds(200, 70, 100, 25);
        panel1.add(lblLname);
        panel1.add(txtLname);
       
        lblFname=new JLabel("First Name: ");
        txtFname=new JTextField(20);
        lblFname.setHorizontalAlignment(JLabel.RIGHT);
        lblFname.setBounds(100, 105, 100, 25);
        txtFname.setBounds(200, 105, 100, 25);
        panel1.add(lblFname);
        panel1.add(txtFname);
       
        lblAddress1=new JLabel("Address 1: ");
        txtAddress1=new JTextField(20);
        lblAddress1.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress1.setBounds(100, 140, 100, 25);
        txtAddress1.setBounds(200, 140, 100, 25);
        panel1.add(lblAddress1);
        panel1.add(txtAddress1);
       
        lblAddress2=new JLabel("Address 2: ");
        txtAddress2=new JTextField(20);
        lblAddress2.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress2.setBounds(100, 175, 100, 25);
        txtAddress2.setBounds(200, 175, 100, 25);
        panel1.add(lblAddress2);
        panel1.add(txtAddress2);
       
        lblCity=new JLabel("City: ");
        txtCity=new JTextField(20);
        lblCity.setHorizontalAlignment(JLabel.RIGHT);
        lblCity.setBounds(100, 210, 100, 25);
        txtCity.setBounds(200, 210, 100, 25);
        panel1.add(lblCity);
        panel1.add(txtCity);
       
        lblState=new JLabel("State: ");
        txtState=new JTextField(20);
        lblState.setHorizontalAlignment(JLabel.RIGHT);
        lblState.setBounds(100, 245, 100, 25);
        txtState.setBounds(200, 245, 100, 25);
        panel1.add(lblState);
        panel1.add(txtState);
       
        lblDOB=new JLabel("DOB: ");
        txtDOB=new JTextField(20);
        lblDOB.setHorizontalAlignment(JLabel.RIGHT);
        lblDOB.setBounds(100, 280, 100, 25);
        txtDOB.setBounds(200, 280, 100, 25);
        panel1.add(lblDOB);
        panel1.add(txtDOB);
       
        lblSalary=new JLabel("Salary: ");
        txtSalary=new JTextField(20);
        lblSalary.setHorizontalAlignment(JLabel.RIGHT);
        lblSalary.setBounds(100, 315, 100, 25);
        txtSalary.setBounds(200, 315, 100, 25);
        panel1.add(lblSalary);
        panel1.add(txtSalary);
       
        btnSave=new JButton("Save Employee");
        btnSave.addActionListener(new Save());
        btnSave.setBounds(80, 360, 130, 25);
        panel1.add(btnSave);
       
        btnClear=new JButton("Clear");
        btnClear.addActionListener(new Clear());
        btnClear.setBounds(230, 360, 130, 25);
        panel1.add(btnClear);
        // PANEL 2
        panel2.setSize(400, 480);
        lblTitle2=new JLabel("EMPLOYEE DELETE DATA");
        lblTitle2.setFont(new Font("Verdana", Font.BOLD, 16));
        lblTitle2.setHorizontalAlignment(JLabel.CENTER);
        lblTitle2.setForeground(Color.BLUE);
        lblTitle2.setBounds(100, 20, 220, 30);
        panel2.add(lblTitle2);
        
        lblid2=new JLabel("Emp ID: ");
        txtid2=new JTextField(20);
        //txtid2.requestFocus();
        lblid2.setHorizontalAlignment(JLabel.RIGHT);
        lblid2.setBounds(100, 345, 100, 25);
        txtid2.setBounds(200, 345, 100, 25);
        panel2.add(lblid2);
        panel2.add(txtid2);
        
        lblLname2=new JLabel("Last Name: ");
        txtLname2=new JTextField(20);
        txtLname2.setEditable(false);
        lblLname2.setHorizontalAlignment(JLabel.RIGHT);
        lblLname2.setBounds(100, 70, 100, 25);
        txtLname2.setBounds(200, 70, 100, 25);
        panel2.add(lblLname2);
        panel2.add(txtLname2);
       
        lblFname2=new JLabel("First Name: ");
        txtFname2=new JTextField(20);
        txtFname2.setEditable(false);
        lblFname2.setHorizontalAlignment(JLabel.RIGHT);
        lblFname2.setBounds(100, 105, 100, 25);
        txtFname2.setBounds(200, 105, 100, 25);
        panel2.add(lblFname2);
        panel2.add(txtFname2);
       
        lblAddress12=new JLabel("Address 1: ");
        txtAddress12=new JTextField(20);
        txtAddress12.setEditable(false);
        lblAddress12.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress12.setBounds(100, 140, 100, 25);
        txtAddress12.setBounds(200, 140, 100, 25);
        panel2.add(lblAddress12);
        panel2.add(txtAddress12);
       
        lblAddress22=new JLabel("Address 2: ");
        txtAddress22=new JTextField(20);
        txtAddress22.setEditable(false);
        lblAddress22.setHorizontalAlignment(JLabel.RIGHT);
        lblAddress22.setBounds(100, 175, 100, 25);
        txtAddress22.setBounds(200, 175, 100, 25);
        panel2.add(lblAddress22);
        panel2.add(txtAddress22);
       
        lblCity2=new JLabel("City: ");
        txtCity2=new JTextField(20);
        txtCity2.setEditable(false);
        lblCity2.setHorizontalAlignment(JLabel.RIGHT);
        lblCity2.setBounds(100, 210, 100, 25);
        txtCity2.setBounds(200, 210, 100, 25);
        panel2.add(lblCity2);
        panel2.add(txtCity2);
       
        lblState2=new JLabel("State: ");
        txtState2=new JTextField(20);
        txtState2.setEditable(false);
        lblState2.setHorizontalAlignment(JLabel.RIGHT);
        lblState2.setBounds(100, 245, 100, 25);
        txtState2.setBounds(200, 245, 100, 25);
        panel2.add(lblState2);
        panel2.add(txtState2);
       
        lblDOB2=new JLabel("DOB: ");
        txtDOB2=new JTextField(20);
        txtDOB2.setEditable(false);
        lblDOB2.setHorizontalAlignment(JLabel.RIGHT);
        lblDOB2.setBounds(100, 280, 100, 25);
        txtDOB2.setBounds(200, 280, 100, 25);
        panel2.add(lblDOB2);
        panel2.add(txtDOB2);
       
        lblSalary2=new JLabel("Salary: ");
        txtSalary2=new JTextField(20);
        txtSalary2.setEditable(false);
        lblSalary2.setHorizontalAlignment(JLabel.RIGHT);
        lblSalary2.setBounds(100, 315, 100, 25);
        txtSalary2.setBounds(200, 315, 100, 25);
        panel2.add(lblSalary2);
        panel2.add(txtSalary2);
       
        btnSearch=new JButton("Search");
        btnSearch.addActionListener(new Search());
        btnSearch.setBounds(70, 390, 80, 25);
        panel2.add(btnSearch);
       
        btnDelete=new JButton("Delete");
        btnDelete.addActionListener(new Delete());
        btnDelete.setEnabled(false);
        btnDelete.setBounds(160, 390, 80, 25);
        panel2.add(btnDelete);
        
        btnClear2=new JButton("Clear");
        btnClear2.addActionListener(new Clear2());
        btnClear2.setEnabled(false);
        btnClear2.setBounds(250, 390, 80, 25);
        panel2.add(btnClear2);
        

        //
        tp.setBounds(0, 0, 400, 480);
        tp.addTab("Insert", panel1);
        tp.addTab("Delete", panel2);
        this.add(tp);
        this.pack();
    }
    private void setFrame()
    {
        super.setTitle("EMPLOYEE DATA ENTRY APP VER 1.0");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocation(200, 100);
        super.setSize(width, height);
        super.setVisible(true);
    }
    private class Save implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String lname=txtLname.getText();
            String fname=txtFname.getText();
            String address1=txtAddress1.getText();
            String address2=txtAddress2.getText();
            String city=txtCity.getText();
            String state=txtState.getText();
            String DOB=txtDOB.getText();
            double salary=Double.parseDouble(txtSalary.getText());
            emp1=new Employee(lname, fname, address1, address2, city, state, DOB, salary);
            try
            {
                crud.insertUser(emp1);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
       
    }
    private class Clear implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            txtLname.setText("");
            txtFname.setText("");
            txtAddress1.setText("");
            txtAddress2.setText("");
            txtCity.setText("");
            txtState.setText("");
            txtDOB.setText("");
            txtSalary.setText("");
        }
       
    }
    private class Search implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
        int id=Integer.parseInt(txtid2.getText());
        emp2=crud.selectEmployee(id);
        if(emp2!=null)
        {
            txtLname2.setText(emp2.getLname());
            txtFname2.setText(emp2.getFname());
            txtAddress12.setText(emp2.getAddress1());
            txtAddress22.setText(emp2.getAddress2());
            txtCity2.setText(emp2.getCity());
            txtState2.setText(emp2.getState());
            txtDOB2.setText(emp2.getDOB());
            txtSalary2.setText(""+emp2.getSalary());
            txtid2.requestFocus();
            btnDelete.setEnabled(true);
            btnClear2.setEnabled(true);
        }
        else
        {
            txtid2.setText("");
            txtid2.requestFocus();
            btnDelete.setEnabled(false);
            btnClear2.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Employee not found");
        }
        }
        
    }
    private class Delete implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
        boolean x=false;
            try
            {
                x=crud.deleteEmployee(emp2.getId());
            }
            catch(Exception ex)
            {
            ex.printStackTrace();
            }
            if(x)
            {
                JOptionPane.showMessageDialog(null, "Employee #"+emp2.getId()+" succesfully deleted");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Unsuccessful Delete");
            }
        }
        
    }
    private class Clear2 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            txtLname2.setText("");
            txtFname2.setText("");
            txtAddress12.setText("");
            txtAddress22.setText("");
            txtCity2.setText("");
            txtState2.setText("");
            txtDOB2.setText("");
            txtSalary2.setText("");
            txtid2.setText("");
            btnDelete.setEnabled(false);
            btnClear2.setEnabled(false);
        }
       
    }
}






