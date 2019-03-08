package sk.tisovy.projectexception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*Example example=new Example();
        example.arrayTestException();
        System.out.println("Hi");*/
        SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-mm-dd");
        Date date1 = null;
        try {
            date1 = dateformat3.parse("2003-06-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Person osoba=new Person("Ivana","Cernecka","036215/4569",date1);
        Database database=new Database();
        database.insertNewPerson(osoba);

    }
    public int add(int a, int b){
        return a+b;
    }
}
