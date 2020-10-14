package Controllers;

import Models.User;
import Services.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {

    private static Connection con = DBConnection.getConnection();

    public static ObservableList<User> getAllUsers() throws SQLException {
        String getUsers = "SELECT * FROM users";
        PreparedStatement pst = con.prepareStatement(getUsers);
        ResultSet rs = pst.executeQuery();
        ObservableList<User> userList = getUserObjects(rs);
        return userList;
    }

    public static void addUser(String nic , String name) throws SQLException {
        String addUser = "INSERT INTO users (nic , name) VALUES (? , ?)";
        PreparedStatement pst = con.prepareStatement(addUser);
        pst.setString(1 , nic);
        pst.setString(2 , name);
        pst.execute();
    }

    public static void deleteUser(int id) throws SQLException {
        String removeUser = "DELETE FROM users WHERE userid=?";
        PreparedStatement pst = con.prepareStatement(removeUser);
        pst.setInt(1 , id);
        pst.execute();
    }

    public static User getUser(String by , String byValue) throws SQLException {
        String getUser = "";
        PreparedStatement pst = null;
        if(by == "nic"){
            getUser = "SELECT * FROM users WHERE nic=?";
            pst = con.prepareStatement(getUser);
            pst.setString(1,byValue);
        }
        else if(by == "id"){
            getUser = "SELECT * FROM users WHERE userid=?";
            pst = con.prepareStatement(getUser);
            pst.setInt(1, Integer.parseInt(byValue));
        }
        ResultSet rs = pst.executeQuery();
       if(rs.next()){
           return setOneUser(rs);
       }
       else return null;
    }

    private static ObservableList<User> getUserObjects(ResultSet rs) throws SQLException {
        ObservableList<User> users =  FXCollections.observableArrayList();
        while (rs.next()){
            users.add(setOneUser(rs));
        }
        return users;
    }

    private static User setOneUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("userid"));
        user.setNIC(rs.getString("nic"));
        user.setName(rs.getString("name"));
        return user;
    }
}
