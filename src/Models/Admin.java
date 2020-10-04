package Models;

import Services.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    public static String username;
    public static String password;

    public static void setAdmin(String newusername , String newpassword){
        username = newusername;
        password = newpassword;
    }
}
