package Services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private DBConnection(){}

    private static Connection connection;

    public static Connection getConnection(){
        String datebaseUsername = "root";
        String datebasePassword = "";
        String url = "jdbc:mysql://localhost/studentlibrary?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,datebaseUsername,datebasePassword);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

}
