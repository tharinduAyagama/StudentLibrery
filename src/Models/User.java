package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private IntegerProperty userId;
    private StringProperty NIC;
    private StringProperty name;

    public User (){
        this.userId = new SimpleIntegerProperty();
        this.NIC = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
    }

    public String getNIC() {
        return NIC.get();
    }

    public StringProperty NICProperty() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC.set(NIC);
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


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
