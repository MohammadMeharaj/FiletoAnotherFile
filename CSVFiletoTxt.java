import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Studentsdet{
    
    String Name;
    int Science;
    int English;
    int Maths;
    public Studentsdet(String Name,int Science,int English,int Maths)
    {
        
        this.Name=Name;
        this.Science=Science;
        this.English=English;
        this.Maths=Maths;
    }
   
}

public class Studentcvs1 {
    public static void main(String[] args) throws IOException  {
        //create a file
        File filename=new File("students.csv");
        // Studentsdet sd = new Studentsdet();
        
            List<Studentsdet>studentdetails=new ArrayList<>();
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you wanna add elements? :");
            String choice = scan.nextLine();
            while(!choice.equalsIgnoreCase("no")){
            
            scan.nextLine();
            System.out.println("Enter Name: ");
            String name = scan.nextLine();
            System.out.println("Enter Maths Marks of a student: ");
            int Maths = scan.nextInt();
            System.out.println("Enter Science Marks of a student:");
            int Science= scan.nextInt();
            System.out.println("Enter English Marks of a student:");
            int English= scan.nextInt();
             //total marks
            
            studentdetails.add(new Studentsdet(name,Maths,Science,English));
            scan.nextLine();
            System.out.println("Do you wanna add elements? ");
            choice = scan.nextLine();
            }
    //write data to file
    try{
       FileWriter fileWriter=new FileWriter("students.csv");
       BufferedWriter bw = new BufferedWriter(fileWriter);
        for(Studentsdet s:studentdetails){
            bw.write(s.Name+","+s.Maths+","+s.Science+","+s.English+"\n");
        }
        bw.flush();
        System.out.println("Data has been written to the file");
    }
    catch(Exception e){
        System.out.println("Error");

    }
    //read student csv data 
    try{ 
        FileReader filereader=new FileReader("students.csv");
        BufferedReader br=new BufferedReader(filereader);
        FileWriter w1=new FileWriter("Another1.txt");
        String Line;
        while ((Line = br.readLine()) != null) 
        {
            String[] values = Line.split(",");
            System.out.println(Line);
                // Calculate the average grade
            int averageGrade = (Integer.parseInt(values[1])+Integer.parseInt(values[2])+Integer.parseInt(values[3])) / 3;

                // Write the result to the output file
            w1.write(values[0] + ":" + averageGrade);
        }
        w1.close();

        System.out.println("Average grades calculated and written to new File");

        } catch (IOException e) {
            e.printStackTrace();
        }
        

        FileReader filereader1=new FileReader("Another1.txt");
        BufferedReader br1=new BufferedReader(filereader1);
        String l;
        while((l=br1.readLine())!=null){
            System.out.println(l);
        }
    }
}

   
