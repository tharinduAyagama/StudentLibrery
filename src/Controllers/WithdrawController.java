package Controllers;

import Models.Books;
import Models.User;
import Models.Withdrowal;
import Services.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawController {
    private static Connection con = DBConnection.getConnection();

    public static ObservableList<Withdrowal> getAllWithdrowal() throws SQLException {
        String getWithdrowal = "SELECT * FROM withdrowal";
        PreparedStatement pst = con.prepareStatement(getWithdrowal);
        ResultSet rs = pst.executeQuery();
        ObservableList<Withdrowal> withdrowalList = getWithdrowalObjects(rs);
        return withdrowalList;
    }

    private static ObservableList<Withdrowal> getWithdrowalObjects(ResultSet rs) throws SQLException {
        ObservableList<Withdrowal> withdrowals =  FXCollections.observableArrayList();
        while (rs.next()){
            withdrowals.add(setOneWithdrowal(rs));
        }
        return withdrowals;
    }

    private static Withdrowal setOneWithdrowal(ResultSet rs) throws SQLException {
        Withdrowal withdrowal = new Withdrowal();
        withdrowal.setWithdrawalId(rs.getInt("withdrowalid"));
        withdrowal.setUserId(rs.getInt("userid"));
        withdrowal.setBookId(rs.getInt("bookid"));
        withdrowal.setNic(UserController.getUser("id" , String.valueOf(rs.getInt("userid"))).getNIC());
        withdrowal.setBookName(BookController.getBook(rs.getInt("bookid")).getBookName());
        return withdrowal;
    }

    public static void withdrawBook(int userId, int bookId) throws SQLException {
        String addWithdrowal = "INSERT INTO withdrowal (userid , bookid) VALUES (? , ?)";
        PreparedStatement pst = con.prepareStatement(addWithdrowal);
        pst.setInt(1 , userId);
        pst.setInt(2,bookId);
        pst.execute();
    }

    public static void removeWithdrow(int withdrawalId) throws SQLException {
        String removeWithdrowal = "DELETE FROM withdrowal WHERE withdrowalid=?";
        PreparedStatement pst = con.prepareStatement(removeWithdrowal);
        pst.setInt(1 , withdrawalId);
        pst.execute();
    }
}
