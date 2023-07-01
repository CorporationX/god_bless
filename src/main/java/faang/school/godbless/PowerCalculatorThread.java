package faang.school.godbless;

public class PowerCalculatorThread extends Thread{
    private Unit unit;
    private int unitPower;

    public PowerCalculatorThread(Unit unit) {
        this.unit = unit;
    }

    public int getUnitPower() {
        return unitPower;
    }

    @Override
    public void run() {
        unitPower = unit.getPower();
    }
}
