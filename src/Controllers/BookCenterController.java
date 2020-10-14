package Controllers;

import Models.Books;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class BookCenterController {
    @FXML
    private Button withdrawButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView table;

    private static Books selectedBook;

    public static Books getSelectedBook() {
        return selectedBook;
    }

    public static void setSelectedBook(Books selectedBook) {
        BookCenterController.selectedBook = selectedBook;
    }

    public void initialize() throws SQLException {
        deleteButton.setDisable(true);
        withdrawButton.setDisable(true);
        table.getColumns().clear();
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deleteButton.setDisable(false);
                withdrawButton.setDisable(false);
            }
        });
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
        StageController.loadStage("../Interfaces/AddBook.fxml" , "Add" ,table);
    }

    public void delete() throws SQLException {
        if(!table.getSelectionModel().isEmpty()){
            Books book = (Books) table.getSelectionModel().getSelectedItem();
            Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = deleteAlert.showAndWait();
            if(result.get() == ButtonType.OK){
                deleteRow(book.getBookId());
            }
        }
        else {
            selectAlert();
        }
    }

    private void deleteRow(int bookId) throws SQLException {
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        BookController.deleteBook(bookId);
    }

    public void withdrawBook() throws IOException {
        if(!table.getSelectionModel().isEmpty()){
            setSelectedBook((Books) table.getSelectionModel().getSelectedItem());
            StageController.loadStage("../Interfaces/Withdrow.fxml" , "Withdraw");
        }
        else {
            selectAlert();
        }
    }

    private void selectAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE , "" , ButtonType.OK);
        alert.setTitle("warning");
        alert.setContentText("please select one row");
        alert.show();
    }
}
