package school.faang.task_48209;

public class CalculatePower implements Runnable {
    private final Unit unit;
    private int power;

    public CalculatePower(Unit unit) {
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
