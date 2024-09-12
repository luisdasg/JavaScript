package homework4;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.FileWriter;
import java.io.IOException;
public class Homework4 {
    static JFrame frame; 
    static JTable table;
    static String [][] temp;
    static ResultSet rs;
    static ArrayList<Employee> rowData=new ArrayList<Employee>();
    public static void main(String[] args) {
            try 
            {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cis144sp","root", "luisdavid8");
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery("select * from employee");
            while(rs.next()){
                rowData.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getDouble(9)));
            }
            int counter=rowData.size();
            int r=0;
            temp=new String[counter][9];
            for(Employee str:rowData){
                temp[r][0]=(String.valueOf(str.getId()));
                temp[r][1]=str.getLname();
                temp[r][2]=str.getFname();
                temp[r][3]=str.getAddress1();
                temp[r][4]=str.getAddress2();
                temp[r][5]=str.getCity();
                temp[r][6]=str.getState();
                temp[r][7]=str.getDOB();
                temp[r][8]=(String.valueOf(str.getSalary()));
                r++;
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        FileWriter csvWriter=null;
        try
        {
            csvWriter=new FileWriter("employee.csv");
            //header row
            csvWriter.append("ID,Last Name,First Name,Address 1,Address 2,City,State,DOB,Salary\n");
            //data rows
            int rows=temp.length;
            int columns=temp[0].length;
            int r=0;
            while(r<rows)
            {
                int c=0;
                while(c<columns){
                    csvWriter.append(temp[r][c]);
                    if(c!=columns-1){
                        csvWriter.append(",");
                    }
                    c++;
                }
                csvWriter.append("\n");
                r++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                csvWriter.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        frame=new JFrame("Luis Application");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cis144sp","root","luisdavid8");
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery("select * from employee");
            while(rs.next()){
                rowData.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9)));
            }
            int counter=rowData.size();
            int r=0;
            temp=new String[counter][9];
            for(Employee str:rowData){
                temp[r][0]=(String.valueOf(str.getId()));
                temp[r][1]=str.getLname();
                temp[r][2]=str.getFname();
                temp[r][3]=str.getAddress1();
                temp[r][4]=str.getAddress2();
                temp[r][5]=str.getCity();
                temp[r][6]=str.getState();
                temp[r][7]=str.getDOB();
                temp[r][8]=(String.valueOf(str.getSalary()));
                r++;
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String[] columnTitles={"ID","Last Name","First Name","Address 1","Address 2","City","State","DOB","Salary"};
       
        table=new JTable(temp,columnTitles);
       
        table.getColumnModel().getColumn(0).setPreferredWidth(25);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(25);
        table.getColumnModel().getColumn(7).setPreferredWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
       
        ListSelectionModel rowSelectionModel=table.getSelectionModel();
        rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowSelectionModel.addListSelectionListener(new luis());
       
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }
    public static class luis implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) 
        { 
            int[] selectedRow=table.getSelectedRows();
            String id="", ln="", fn="", city="";
            for(int i=0;i<selectedRow.length;i++){
                id=(String)table.getValueAt(selectedRow[i], 0);
                ln=(String)table.getValueAt(selectedRow[i], 1);
                fn=(String)table.getValueAt(selectedRow[i], 2);
                city=(String)table.getValueAt(selectedRow[i], 5);
            }
            StringBuilder sb=new StringBuilder();
            sb.append("Employee INFO\n");
            sb.append("=============\n");
            sb.append("Employee ID: "+id+"\n");
            sb.append("Employee Last Name: "+ln+"\n");
            sb.append("Employee First Name: "+fn+"\n");
            sb.append("Employee City: "+city+"\n");
           
            JOptionPane.showMessageDialog(frame, sb.toString(), "Record Selected", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
