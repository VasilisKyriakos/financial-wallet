import java.lang.String;

public class Transaction {
    private BankAccount from;
    private BankAccount to;
    private float amount;
    private boolean pending;

    private boolean valid;

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


    public void executeTransfer() {
        to.addBalance(amount);
        from.addBalance(-amount);
        pending = false;
        //System.out.println();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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


    public Transaction(BankAccount from, BankAccount to, float amount, int id, String type) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pending = true;
        this.id = id;
        this.type = type;

    }

}

