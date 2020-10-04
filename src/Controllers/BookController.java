package Controllers;

import Models.Books;
import Services.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {
    public static ObservableList<Books> getAllBooks() throws SQLException {
        Connection con = DBConnection.getConnection();
        String ifAdmin = "SELECT * FROM books";
        PreparedStatement pst = con.prepareStatement(ifAdmin);
        ResultSet rs = pst.executeQuery();
        ObservableList<Books> bookList = getBooksObjects(rs);
        return bookList;
    }

    private static ObservableList<Books> getBooksObjects(ResultSet rs) throws SQLException {

        ObservableList<Books> books =  FXCollections.observableArrayList();
        while (rs.next()){
            Books book = new Books();
            book.setBookId(rs.getInt("bookid"));
            book.setBookName(rs.getString("bookname"));
            book.setInCount(rs.getInt("incount"));
            book.setOutCount(rs.getInt("outcount"));
            books.add(book);
        }
        return books;
    }
}
