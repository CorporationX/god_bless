package school.faang.army;

public class Archer extends Unit {
    private int power;

    public Archer(int power) {
        super(power);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Archer with power  " + getPower() + " is running.");
    }
}