package javaapplication11;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class JavaApplication11 {
    static FileReader myFile=null;
    static BufferedReader br=null;
    static Scanner sc=null;
    static String row=null;
    static int index=1;
    public static void main(String[] args) {
        try{
            myFile =new FileReader("C:\\Users\\luisd\\OneDrive\\Escritorio\\employees.csv");
            br=new BufferedReader(myFile);
            while((row=br.readLine())!=null)
            {
                sc=new Scanner(row);
                sc.useDelimiter(",");
                while(sc.hasNext())
                {
                    String Column=sc.next();
                    System.out.print(Column+"\t");
                    index++;
                }
                System.out.println();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
        
    
}
