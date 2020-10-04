package Controllers;

import Models.Books;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DashController {
    @FXML
    public BorderPane borderPane;

    public void clickBooks() throws IOException {
        Parent bookCenter = FXMLLoader.load(getClass().getResource("../Interfaces/BookCenter.fxml"));
        borderPane.setCenter(bookCenter);
    }

    public void clickStudents() {
        
    }

}
