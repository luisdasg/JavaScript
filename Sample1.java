package sample1;
import java.io.*;
import java.util.Scanner;
public class Sample1 {
        static FileWriter myFile;
        static BufferedWriter realfile;
        static PrintWriter pw;
        static Scanner sc;
        static int NumOfEmp;
        static String EmpName;
        static int EmpAge;
        static String EmpPosition;
    public static void main(String[] args) {
        try{
            sc=new Scanner(System.in);
            myFile =new FileWriter("employee.csv", true);
            realfile = new BufferedWriter(myFile);
            pw =new PrintWriter(realfile);
            System.out.print("How many employees do you want to enter? ");
            NumOfEmp=sc.nextInt();
            for(int i=0; i<NumOfEmp; i++)
            {
                sc.nextLine();
                System.out.print("Enter employee name: ");
                EmpName=sc.next();
                System.out.print("Enter employee age: ");
                EmpAge=sc.nextInt();
                System.out.print("Enter employee position: ");
                EmpPosition=sc.next();
                pw.write(EmpName+", "+EmpAge+", "+EmpPosition+"\n");
            }
            pw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
}
