package JDBC;

import java.sql.*;

public class Test {

  public static void main() throws ClassNotFoundException, SQLException {

    //Connection con = DriverManager.getConnection(dbUrl,username,password);
    String dbUrl = "jdbc:mysql://54.208.87.86:3306/RBDG";
    //Database Username
    String username = "php";
    String password = "jjOoan1UVZpDBA5p5YHY";
    //Querry to Execute
    String query = "select * from PATRON LIMIT 20;";

    Class.forName("com.mysql.jdbc.Driver");

    //Create Connection to DB
    Connection con = DriverManager.getConnection(dbUrl, username, password);

    //Create Statement Object
    Statement stmt = con.createStatement();

    // Execute the SQL Query. Store results in ResultSet
    ResultSet rs = stmt.executeQuery(query);
  }
}
