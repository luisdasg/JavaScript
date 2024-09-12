package FinalProjectModel;
import java.sql.*;
import java.sql.SQLException;
public class EmployeeCRUD {
    private String jdbcURL="jdbc:mysql://localhost:3306/cis144sp";
    private String jdbcusername="root";
    private String jdbcPassword="luisdavid8";
   
    private static String DELETE_EMPLOYEE_SQL="delete from employee where empID=?";
    private static String INSERT_EMPLOYEE_SQL="insert into employee(EmpLname, EmpFname, EmpAddress1, EmpAddress2, EmpCity, "
            + "EmpState, EmpDOB, EmpBaseSalary)"
            + " values(?,?,?,?,?,?,?,?)";
    
    private static String SELECT_EMPLOYEE_BY_ID="select EmpID, EmpLname, EmpFname, EmpAddress1, EmpAddress2, EmpCity, "
            + "EmpState, EmpDOB, EmpBaseSalary from employee where EmpID=?";
    
    
    public EmployeeCRUD()
    {
       
    }
    protected Connection getConnection()
    {
        Connection conn=null;
        try
        {
            conn=DriverManager.getConnection(jdbcURL, jdbcusername, jdbcPassword);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }  
    public void insertUser(Employee employee)
    {
        try(Connection gust=this.getConnection();
            PreparedStatement ps=gust.prepareStatement(INSERT_EMPLOYEE_SQL);)
        {
           ps.setString(1, employee.getLname());
           ps.setString(2, employee.getFname());
           ps.setString(3, employee.getAddress1());
           ps.setString(4, employee.getAddress2());
           ps.setString(5, employee.getCity());
           ps.setString(6, employee.getState());
           ps.setString(7, employee.getDOB());
           ps.setDouble(8, employee.getSalary());
           ps.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public boolean deleteEmployee(int empID)
    {
        boolean rowDeleted=false;
        try(Connection gust=this.getConnection();
            PreparedStatement ps=gust.prepareStatement(DELETE_EMPLOYEE_SQL);)
        {
            ps.setInt(1, empID);
            rowDeleted=ps.executeUpdate()>0;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return rowDeleted;
    }
    
    public Employee selectEmployee(int empID)
    {
        Employee employee=null;
        try
        {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, empID);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next())
            {
                String lname=rs.getString("EmpLname");
                String fname=rs.getString("EmpFname");
                String address1=rs.getString("EmpAddress1");
                String address2=rs.getString("EmpAddress2");
                String city=rs.getString("EmpCity");
                String state=rs.getString("EmpState");
                String DOB= rs.getString("EmpDOB");
                double salary=rs.getDouble("EmpBaseSalary");
                employee=new Employee(empID, lname, fname, address1, address2, city, state, DOB, salary);
                
                
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return employee;
    }
}