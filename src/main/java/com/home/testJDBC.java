package main.java.com.home;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 7/9/17.
 */
public class testJDBC {
    public static void main(String[] args) {
        PreparedStatement pst =  null;
        System.out.println("hello");

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e){
            System.out.println("where is your postgresql jdbc driver&");
            e.printStackTrace();
            return;
        }
        System.out.println("driver ok");
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres", "123456");
            String stm = "INSERT INTO table_people(name, age, city, pet) VALUES(?,?,?,?)";
            pst = connection.prepareStatement(stm);
            pst.setString(1, "testTest");
            pst.setInt(2, 47);
            pst.setString(3, "testTest");
            pst.setString(4, "testTest");
            pst.executeUpdate();
            pst.close();
            connection.close();
        }
            catch (SQLException e){
                System.out.println("connection failed");
                e.printStackTrace();
                return;
            }
    }


    }
