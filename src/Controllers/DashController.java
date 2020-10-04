package Controllers;

import Models.Books;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class DashController {
    @FXML
    private TableView table;

    public void clickBooks(MouseEvent event) throws SQLException {
        table.getColumns().clear();
        TableColumn<Books , Integer> id = new TableColumn("ID");
        TableColumn<Books , String> name = new TableColumn("Name");
        TableColumn<Books , Integer> inCount = new TableColumn("In Count");
        TableColumn<Books , Integer> outCount = new TableColumn("Out Count");
        table.getColumns().addAll(id , name , inCount , outCount);

        id.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty().asObject());
        name.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty());
        inCount.setCellValueFactory(cellData -> cellData.getValue().inCountProperty().asObject());
        outCount.setCellValueFactory(cellData -> cellData.getValue().outCountProperty().asObject());

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(BookController.getAllBooks());
    }

    public void clickStudents(MouseEvent event) {
        table.getColumns().clear();
        table.getColumns().addAll(new TableColumn<>("ID") ,
                new TableColumn<>("NIC") ,
                new TableColumn<>("Name")
        );
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
