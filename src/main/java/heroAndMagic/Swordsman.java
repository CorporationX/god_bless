package heroAndMagic;

public class Swordsman extends Character implements Runnable {
    private final int POWER = 50;
    private int quantity;

    public Swordsman(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void run() {
        total = quantity * POWER;
        System.out.println(total);
    }
}
