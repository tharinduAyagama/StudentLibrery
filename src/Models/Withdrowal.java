package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Withdrowal {
    private IntegerProperty withdrawalId;
    private IntegerProperty userId;
    private IntegerProperty bookId;
    private StringProperty nic;
    private StringProperty bookName;

    public Withdrowal(){
        this.withdrawalId = new SimpleIntegerProperty();
        this.userId = new SimpleIntegerProperty();
        this.bookId = new SimpleIntegerProperty();
        this.nic = new SimpleStringProperty();
        this.bookName = new SimpleStringProperty();
    }

    public String getNic() {
        return nic.get();
    }

    public StringProperty nicProperty() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic.set(nic);
    }

    public String getBookName() {
        return bookName.get();
    }

    public StringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public int getWithdrawalId() {
        return withdrawalId.get();
    }

    public IntegerProperty withdrawalIdProperty() {
        return withdrawalId;
    }

    public void setWithdrawalId(int withdrawalId) {
        this.withdrawalId.set(withdrawalId);
    }

    public int getUserId() {
        return userId.get();
    }

    public IntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public int getBookId() {
        return bookId.get();
    }

    public IntegerProperty bookIdProperty() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId.set(bookId);
    }
}
