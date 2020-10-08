package Controllers;

import Models.Admin;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends Application {
    @FXML
    private TextField userNameBox;
    @FXML
    private TextField passwordBox;

    @Override
    public void start(Stage stage) throws Exception {
        StageController.loadStage("../Interfaces/Login.fxml" , "Login");
    }

    public void loginAction() throws Exception {
        Admin.setAdmin(userNameBox.getText() , passwordBox.getText());
        if(AdminController.isAdmin()){
            Stage current = (Stage)userNameBox.getScene().getWindow();
            current.close();
            StageController.loadStage("../Interfaces/Dashbord.fxml" , "Dashbord");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.NONE ,"" , ButtonType.OK);
            alert.setTitle("Error");
            alert.setContentText("Enter the username and password correct");
            alert.show();
        }
    }
}
