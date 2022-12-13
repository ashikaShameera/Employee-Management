package EmpApp;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection connection;

    public static Connection createDatabaseConnection(){
        String url="jdbc:mysql://localhost:3306/employee?useSSL=false";
        String username="root";
        String password="lucifer123";

        try {
            //load driver
            Class.forName("com.mysql.jdbc.Driver");
            //getting connection
            connection=DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
