package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
public class DashController {
    @FXML
    public BorderPane borderPane;

    public void clickBooks() throws IOException {
        Parent bookCenter = FXMLLoader.load(getClass().getResource("../Interfaces/BookCenter.fxml"));
        borderPane.setCenter(bookCenter);
    }

    public void clickStudents() throws IOException {
        Parent bookCenter = FXMLLoader.load(getClass().getResource("../Interfaces/UserCenter.fxml"));
        borderPane.setCenter(bookCenter);
    }

    public void clickWithdrowals() throws IOException {
        Parent withdrowCenter = FXMLLoader.load(getClass().getResource("../Interfaces/WithdrowCenter.fxml"));
        borderPane.setCenter(withdrowCenter);
    }
}
