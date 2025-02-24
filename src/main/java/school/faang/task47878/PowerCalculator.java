package school.faang.task47878;

public class PowerCalculator implements Runnable {
    private final Unit unit;
    private int power;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }

    public int getPower() {
        return power;
    }

}
