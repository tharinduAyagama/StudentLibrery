package Controllers;

import Models.Books;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class BookCenterController {
    @FXML
    private TableView table;

    public void initialize() throws SQLException {
        table.getColumns().clear();
        TableColumn<Books, Integer> id = new TableColumn("ID");
        TableColumn<Books , String> name = new TableColumn("Name");
        TableColumn<Books , Integer> inCount = new TableColumn("In Count");
        TableColumn<Books , Integer> outCount = new TableColumn("Out Count");
        table.getColumns().addAll(id , name , inCount , outCount);

        id.setStyle("-fx-alignment: CENTER");
        name.setStyle("-fx-alignment: CENTER");
        inCount.setStyle("-fx-alignment: CENTER");
        outCount.setStyle("-fx-alignment: CENTER");

        id.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty().asObject());
        name.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty());
        inCount.setCellValueFactory(cellData -> cellData.getValue().inCountProperty().asObject());
        outCount.setCellValueFactory(cellData -> cellData.getValue().outCountProperty().asObject());

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(BookController.getAllBooks());
    }

    public void addBook() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../Interfaces/AddBook.fxml"));
        Scene addScene = new Scene(parent);
        Stage addStage = new Stage();
        addStage.setTitle("Add");
        addStage.setScene(addScene);
        addStage.show();
    }
}
