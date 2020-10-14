package Controllers;

import Models.Withdrowal;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.Optional;

public class WithdrawCenterController {
    @FXML
    private TableView table;
    @FXML
    private Button recieveButton;

    public void initialize() throws SQLException {
        recieveButton.setDisable(true);
        table.getColumns().clear();
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                recieveButton.setDisable(false);
            }
        });
        TableColumn<Withdrowal , String> nic = new TableColumn("NIC");
        TableColumn<Withdrowal , String> bookName = new TableColumn("Book Name");
        table.getColumns().addAll(nic , bookName);

        nic.setStyle("-fx-alignment: CENTER");
        bookName.setStyle("-fx-alignment: CENTER");

        nic.setCellValueFactory(cellData -> cellData.getValue().nicProperty());
        bookName.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty());

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(WithdrawController.getAllWithdrowal());
    }

    public void bookRecieve() throws SQLException {
        if(!table.getSelectionModel().isEmpty()){
            TableRow r = new TableRow();
            Withdrowal withdrowal = (Withdrowal) table.getSelectionModel().getSelectedItem();
            Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> result = deleteAlert.showAndWait();
            if(result.get() == ButtonType.OK){
                bookRecieved(withdrowal.getWithdrawalId() , withdrowal.getBookId());
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.NONE , "" , ButtonType.OK);
            alert.setTitle("warning");
            alert.setContentText("please select one row");
            alert.show();
        }
    }

    private void bookRecieved(int withdrawalId, int bookId) throws SQLException {
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        WithdrawController.removeWithdrow(withdrawalId);
        BookController.updateToRecieve(bookId);
    }
}
