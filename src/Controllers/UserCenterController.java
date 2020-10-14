package Controllers;

import Models.User;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class UserCenterController {
    @FXML
    private Button deleteButton;
    @FXML
    private TableView table;

    public void initialize() throws SQLException {
        deleteButton.setDisable(true);
        table.getColumns().clear();
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deleteButton.setDisable(false);
            }
        });
        TableColumn<User, Integer> id = new TableColumn("ID");
        TableColumn<User , String> nic = new TableColumn("NIC");
        TableColumn<User , String> name = new TableColumn("Name");
        table.getColumns().addAll(id , nic , name);

        id.setStyle("-fx-alignment: CENTER");
        nic.setStyle("-fx-alignment: CENTER");
        name.setStyle("-fx-alignment: CENTER");

        id.setCellValueFactory(cellData -> cellData.getValue().userIdProperty().asObject());
        nic.setCellValueFactory(cellData -> cellData.getValue().NICProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(UserController.getAllUsers());
    }

    public void addUser() throws IOException {
        StageController.loadStage("../Interfaces/AddUser.fxml" , "Add");
    }

    public void delete() throws SQLException {
        if(!table.getSelectionModel().isEmpty()){
        User user = (User) table.getSelectionModel().getSelectedItem();
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> result = deleteAlert.showAndWait();
        if(result.get() == ButtonType.OK){
            deleteRow(user.getUserId());
        }
    }
        else {
            Alert alert = new Alert(Alert.AlertType.NONE , "" , ButtonType.OK);
            alert.setTitle("warning");
            alert.setContentText("please select one row");
            alert.show();
        }
    }

    private void deleteRow(int userID) throws SQLException {
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        UserController.deleteUser(userID);
    }
}
