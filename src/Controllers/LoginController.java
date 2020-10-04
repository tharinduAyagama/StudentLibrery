package Controllers;

import Models.Admin;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController extends Application {
    @FXML
    private TextField userNameBox;
    @FXML
    private TextField passwordBox;

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../Interfaces/Login.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.show();
    }

    public void loginAction(MouseEvent event) throws Exception {
        Admin.setAdmin(userNameBox.getText() , passwordBox.getText());
        if(AdminController.isAdmin()){
            Parent parent = FXMLLoader.load(getClass().getResource("../Interfaces/Dashbord.fxml"));
            Scene sceneDash = new Scene(parent);
            Stage dashStage = new Stage();
            Stage current = (Stage)userNameBox.getScene().getWindow();
            current.close();
            dashStage.setScene(sceneDash);
            dashStage.setTitle("Dashbord");
            dashStage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.NONE ,"" , ButtonType.OK);
            alert.setTitle("Error");
            alert.setContentText("Enter the username and password correct");
            alert.show();
        }
    }
}
