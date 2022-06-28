import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


class StudentList {
    BufferedReader bufferReader;

    {
        try {
            bufferReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constant.StudentList)
                    )
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String[] getNames() throws IOException {
        String names = bufferReader.readLine();
        String studentNames[] = names.split(", ");
        return studentNames;
    }

    public void a() {

        try {
            String[] studentNames = getNames();
            for (String studentName : studentNames) {
                System.out.println(studentName);
            }
        } catch (Exception e) {

        }
    }

    public void r() {
        try {
            String[] studentNames = getNames();

            // generating random int [0,length)
            int length = studentNames.length;
            Random random = new Random();
            int randomNumber = random.nextInt(length);

            System.out.println(studentNames[randomNumber]);
        } catch (Exception e) {
        }
    }

    public void plus(String args[]) {
        System.out.println(Constant.LoadingMessage);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(Constant.StudentList, true));
            String t = args[0].substring(1);
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat(Constant.DateFormatString);
            String fullDate = dateFormat.format(date);
            bufferedWriter.write(Constant.SubmitDateString + fullDate);
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void c() {

        try {
            String[] studentNames = getNames();
            System.out.println(studentNames.length + " names found");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void question(String args[]) {

        try {
            String[] studentNames = getNames();
            int length = studentNames.length;
            String student = args[1];
            System.out.println();

            for (int idx = 0; idx < length; idx++) {
                if (studentNames[idx].equals(student)) {
                    System.out.println(student + Constant.SearchSuccessMessage);
                    return;
                }
            }
            System.out.println(Constant.SearchFailedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class Main {


    public static void main(String[] args) {
        StudentList studentList = new StudentList();


        System.out.println(Constant.LoadingMessage);

        //		Check arguments
        switch (args[0]) {
            case Constant.ShowAll:
                studentList.a();
                break;
            case Constant.ShowRandom:
                studentList.r();
                break;
            case Constant.AddStudentName:
                studentList.plus(args);
                break;
            case Constant.StudentSearch:
                studentList.question(args);
                break;
            case Constant.StudentCount:
                studentList.c();
                break;
            default:
                System.out.println(Constant.WarningMessage);
                System.out.println(Constant.GUIDE);
        }

        System.out.println(Constant.LoadingSuccessMessage);

    }

}
