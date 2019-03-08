package sk.tisovy.projectexception;

import java.sql.*;
import java.util.Calendar;

public class Database {
    private final String username="klaudia";
    private final String password="tomas";
    private final String url = "jdbc:mysql://localhost:3306/db1";

    private Connection getConnection(){
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
            connection = DriverManager.getConnection(url,username,password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertNewPerson(Person person){
        Connection conn=getConnection();
        try {
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO person(fname,lname,dob,pin) values(?,?,?,?)");
            stmt.setString(1,person.getFname());
            stmt.setString(2,person.getLname());
            stmt.setDate(3,new Date(person.getDob().getTime()));
            stmt.setString(4,person.getPin());
            int result=stmt.executeUpdate();

            closeConnection(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection conn){
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
