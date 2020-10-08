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

    private static Connection con = DBConnection.getConnection();

    public static ObservableList<Books> getAllBooks() throws SQLException {
        String getBooks = "SELECT * FROM books";
        PreparedStatement pst = con.prepareStatement(getBooks);
        ResultSet rs = pst.executeQuery();
        ObservableList<Books> bookList = getBooksObjects(rs);
        return bookList;
    }

    public static void addBook(String name , int noOfBooks) throws SQLException {
        String addBook = "INSERT INTO books (bookname , incount , outcount) VALUES (? , ? , ?)";
        PreparedStatement pst = con.prepareStatement(addBook);
        pst.setString(1 , name);
        pst.setInt(2 , noOfBooks);
        pst.setInt(3,0);
        pst.execute();
    }

    public static void deleteBook(int id) throws SQLException {
        String removeBook = "DELETE FROM books WHERE bookid=?";
        PreparedStatement pst = con.prepareStatement(removeBook);
        pst.setInt(1 , id);
        pst.execute();
    }

    public static Books getBook(int id) throws SQLException {
        String getBook = "SELECT * FROM books WHERE bookid=?";
        PreparedStatement pst = con.prepareStatement(getBook);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        return setOneBook(rs);
    }

    private static ObservableList<Books> getBooksObjects(ResultSet rs) throws SQLException {

        ObservableList<Books> books =  FXCollections.observableArrayList();
        while (rs.next()){
            books.add(setOneBook(rs));
        }
        return books;
    }

    private static Books setOneBook(ResultSet rs) throws SQLException {
        Books book = new Books();
        book.setBookId(rs.getInt("bookid"));
        book.setBookName(rs.getString("bookname"));
        book.setInCount(rs.getInt("incount"));
        book.setOutCount(rs.getInt("outcount"));
        return book;
    }
}
