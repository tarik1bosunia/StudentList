import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


class StudentList{
    public void a(){
        System.out.println("Loading data ...");
        try {
            BufferedReader bufferReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")
                    )
            );
            String names = bufferReader.readLine();
            String studentNames[] = names.split(", ");
            for (String j : studentNames) {
                System.out.println(j);
            }
        } catch (Exception e) {

        }
        System.out.println("Data Loaded.");
    }


    public void r(){
        System.out.println("Loading data ...");
        try {
            BufferedReader s = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
            String r = s.readLine();
            System.out.println(r);
            String i[] = r.split(", ");
            Random x = new Random();
            int length = i.length;
            int y = x.nextInt(length);
            System.out.println(i[y]);
        } catch (Exception e) {
        }
        System.out.println("Data Loaded.");
    }
    public void plus(String args[]){
        System.out.println("Loading data ...");
        try {
            BufferedWriter s = new BufferedWriter(
                    new FileWriter("students.txt", true));
            String t = args[0].substring(1);
            Date d = new Date();
            String df = "dd/mm/yyyy-hh:mm:ss a";
            DateFormat dateFormat = new SimpleDateFormat(df);
            String fd = dateFormat.format(d);
            s.write(", " + t + "\nList last updated on " + fd);
            s.close();
        } catch (Exception e) {
        }

        System.out.println("Data Loaded.");
    }
    public void c(){
        System.out.println("Loading data ...");
        try {
            BufferedReader s = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
            String D = s.readLine();
            char a[] = D.toCharArray();
            boolean in_word = false;
            int count = 0;
            for (char c : a) {
                if (c == ' ') {
                    if (!in_word) {
                        count++;
                        in_word = true;
                    } else {
                        in_word = false;
                    }
                }
            }
            System.out.println(count + " word(s) found ");
        } catch (Exception e) {
        }
        System.out.println("Data Loaded.");
    }
    public  void question(String args[]){
        System.out.println("Loading data ...");
        try {
            BufferedReader s = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
            String r = s.readLine();
            String i[] = r.split(",");
            boolean done = false;
            String t = args[0].substring(1);
            for (int idx = 0; idx < i.length && !done; idx++) {
                if (i[idx].equals(t)) {
                    System.out.println("We found it!");
                    done = true;
                }
            }
        } catch (Exception e) {
        }
        System.out.println("Data Loaded.");
    }
}

public class Main {


    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        boolean isRunning = true;

        while (isRunning == true){
            //		Check arguments
            if(args[0].equals("e")){
                isRunning = false;
            }
            else if (args[0].equals("a")) {
                studentList.a();
            } else if (args[0].equals("r")) {
                studentList.r();
            } else if (args[0].contains("+")) {
                studentList.plus(args);
            } else if (args[0].contains("?")) {
                studentList.question(args);
            } else if (args[0].contains("c")) {
                studentList.c();
            }

            System.out.println(
                            "to see all the students list press a then enter\n"
                            + "to see a random student press r then enter\n"
                            +"to exit press e then enter\n"
            );

            Scanner scanner = new Scanner(System.in);
            args[0] = scanner.nextLine();

        }


    }

}
