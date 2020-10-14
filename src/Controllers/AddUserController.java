package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddUserController {
    @FXML
    public TextField nicBox;
    @FXML
    public TextField nameBox;

    public void add() throws SQLException {
        String name = nameBox.getText();
        String nic = nicBox.getText();
        UserController.addUser(nic , name);
        Stage current = (Stage)nameBox.getScene().getWindow();
        current.close();
        TableView tableView = (TableView) current.getUserData();
        tableView.setItems(UserController.getAllUsers());
    }
}
