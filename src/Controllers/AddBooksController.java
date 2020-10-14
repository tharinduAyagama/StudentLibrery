package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddBooksController{
    @FXML
    public TextField nameBox;
    @FXML
    public TextField countBox;

    public void add() throws SQLException {
        String name = nameBox.getText();
        int noOfBooks = Integer.parseInt(countBox.getText());
        BookController.addBook(name , noOfBooks);
        Stage current = (Stage)nameBox.getScene().getWindow();
        current.close();
        TableView tableView = (TableView) current.getUserData();
        tableView.setItems(BookController.getAllBooks());
    }
}
