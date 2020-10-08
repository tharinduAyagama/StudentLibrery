package Controllers;

import Models.Books;
import Models.User;
import Services.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WithdrawController {
    @FXML
    public TextField nicBox;

    private User user;
    private Books book;

    public void withdraw() throws SQLException {
        user = UserController.getUser("nic" , nicBox.getText());
        book = BookCenterController.getSelectedBook();
        if(user != null && book.getInCount()!= 0){
            withdrawBook(user.getUserId() , book.getBookId());
            Stage current = (Stage)nicBox.getScene().getWindow();
            current.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.NONE ,"" , ButtonType.OK);
            alert.setTitle("Error");
            alert.setContentText("There is not any matching NIC");
            alert.show();
        }
    }

    private void withdrawBook(int userId, int bookId) throws SQLException {
        Connection con = DBConnection.getConnection();
        String addWithdrowal = "INSERT INTO withdrowal (userid , bookid) VALUES (? , ?)";
        PreparedStatement pst = con.prepareStatement(addWithdrowal);
        pst.setInt(1 , userId);
        pst.setInt(2,bookId);
        pst.execute();
    }
}
