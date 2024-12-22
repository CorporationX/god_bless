package school.faang.army;

public class Mage extends Unit {
    private int power;

    public Mage(int power) {
        super(power);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Mage with power " + getPower() + " is running.");
    }
}
