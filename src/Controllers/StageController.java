package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageController {
    public static void loadStage(String path , String title) throws IOException {
        Parent parent = FXMLLoader.load(StageController.class.getResource(path));
        Scene addScene = new Scene(parent);
        Stage addStage = new Stage();
        addStage.setTitle(title);
        addStage.setScene(addScene);
        addStage.show();
    }
}
