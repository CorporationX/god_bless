package school.faang.multithreadingarmy;

public class PowerCalculator implements Runnable {

    private int power;
    private final Unit unit;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }

    public int getPower() {
        return power;
    }
}
