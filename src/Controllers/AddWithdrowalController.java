package Controllers;

import Models.Books;
import Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddWithdrowalController {
    @FXML
    public TextField nicBox;

    private User user;
    private Books book;

    public void withdraw() throws SQLException {
        user = UserController.getUser("nic" , nicBox.getText());
        book = BookCenterController.getSelectedBook();
        if(user != null && book.getInCount()!= 0){
            WithdrawController.withdrawBook(user.getUserId() , book.getBookId());
            BookController.updateToWithdrowal(book.getBookId());
            Stage current = (Stage)nicBox.getScene().getWindow();
            current.close();
            TableView tableView = (TableView) current.getUserData();
            tableView.setItems(BookController.getAllBooks());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.NONE ,"" , ButtonType.OK);
            alert.setTitle("Error");
            alert.setContentText("There is not any matching NIC");
            alert.show();
        }
    }
}
