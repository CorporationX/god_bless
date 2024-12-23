package school.faang.army;

public class Swordsman extends Unit {
    public Swordsman(int power) {
        super(power);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Swordsman with power " + getPower() + " is running.");
    }
}
