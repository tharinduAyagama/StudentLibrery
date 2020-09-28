import Controllers.LoginController;
import Services.DBConnection;
import javafx.application.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Connection connection = DBConnection.getConnection();
//
//        String x = "cvv";
//
//        String queary = "INSERT INTO users(nic , name) VALUES (? , ?)";
//
//        try {
//            PreparedStatement statement = connection.prepareStatement(queary);
//            statement.setString(1 , "972691313v");
//            statement.setString(2 , "tharindu");
//            statement.execute();
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }

        Application.launch(LoginController.class);


    }
}
