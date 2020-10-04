package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Books {
    public IntegerProperty bookId;
    public StringProperty bookName;
    public IntegerProperty inCount;
    public IntegerProperty outCount;

    public Books(){
        this.bookId = new SimpleIntegerProperty();
        this.bookName = new SimpleStringProperty();
        this.inCount = new SimpleIntegerProperty();
        this.outCount = new SimpleIntegerProperty();
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

    public String getBookName() {
        return bookName.get();
    }

    public StringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public int getInCount() {
        return inCount.get();
    }

    public IntegerProperty inCountProperty() {
        return inCount;
    }

    public void setInCount(int inCount) {
        this.inCount.set(inCount);
    }

    public int getOutCount() {
        return outCount.get();
    }

    public IntegerProperty outCountProperty() {
        return outCount;
    }

    public void setOutCount(int outCount) {
        this.outCount.set(outCount);
    }
}
