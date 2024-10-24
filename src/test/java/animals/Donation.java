package animals;

public class Donation {
    private int id;
    private double amount;

    public Donation(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
