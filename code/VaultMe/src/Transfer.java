import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class Transfer {
    private BankAccount from;
    private BankAccount to;
    private float amount;
    private boolean pending;


    public void executeTransfer(){
        to.addBalance(amount);
        from.addBalance(-amount);
        pending = false;
    }



    public BankAccount getFrom() {
        return from;
    }

    public BankAccount getTo() {
        return to;
    }

    public float getAmount() {
        return amount;
    }

    public boolean isPending() {
        return pending;
    }

    public void setFrom(BankAccount from) {
        this.from = from;
    }

    public void setTo(BankAccount to) {
        this.to = to;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }


    public Transfer(BankAccount from, BankAccount to, float amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pending = true;
    }
}
