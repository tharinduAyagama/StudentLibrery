package Controllers;

import Models.Admin;
import Services.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController extends Admin {
    public static boolean isAdmin() throws SQLException {
        Connection con = DBConnection.getConnection();
        String ifAdmin = "SELECT adminid FROM admins WHERE username=? AND password=?";
        PreparedStatement pst = con.prepareStatement(ifAdmin);
        pst.setString(1 , username);
        pst.setString(2 , password);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return true;
        }
        else return false;
    }
}
