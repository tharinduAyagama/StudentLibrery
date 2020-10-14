package Controllers;

import Models.Withdrowal;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    @FXML
    private TextField searchBox;

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

        FilteredList<Withdrowal> filteredList = new FilteredList<>(WithdrawController.getAllWithdrowal() , withdrowal -> true);
        searchBox.textProperty().addListener((observable , aldValue , newValue)->{
            filteredList.setPredicate(Withdrowal->{
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(Withdrowal.getNic().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else if(Withdrowal.getBookName().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }
                else return false;
            });
        });
        SortedList<Withdrowal> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedList);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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
        table.setItems(WithdrawController.getAllWithdrowal());
        WithdrawController.removeWithdrow(withdrawalId);
        BookController.updateToRecieve(bookId);
    }

    public void enterToBox() {
        searchBox.setTooltip(
                new Tooltip("Search by NIC and name")
        );
    }
}
