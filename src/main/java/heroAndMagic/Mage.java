package heroAndMagic;

public class Mage extends Character implements Runnable {
    private final int POWER = 25;
    private int quantity;

    public Mage(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void run() {
        total = quantity * POWER;
        System.out.println(total);
    }

}
