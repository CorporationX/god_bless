package heroAndMagic;

public class Archer extends Character implements Runnable {
    private final int POWER = 10;
    private int quantity;

    public Archer(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void run() {
        total = quantity * POWER;
    }
}
