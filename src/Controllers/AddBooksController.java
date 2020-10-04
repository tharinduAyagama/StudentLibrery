package Controllers;

import Services.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBooksController {

    @FXML
    public TextField nameBox;
    @FXML
    public TextField countBox;

    public void addBook() throws SQLException {
        String name = nameBox.getText();
        int noOfBooks = Integer.parseInt(countBox.getText());
        Connection con = DBConnection.getConnection();
        String addBook = "INSERT INTO books (bookname , incount , outcount) VALUES (? , ? , ?)";
        PreparedStatement pst = con.prepareStatement(addBook);
        pst.setString(1 , name);
        pst.setInt(2 , noOfBooks);
        pst.setInt(3,0);
        pst.execute();
        Stage current = (Stage)nameBox.getScene().getWindow();
        current.close();
    }
}
