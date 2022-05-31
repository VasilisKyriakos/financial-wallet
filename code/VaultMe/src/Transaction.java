import java.util.ArrayList;
import java.util.Random;

public class Transaction {

    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Transaction(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
