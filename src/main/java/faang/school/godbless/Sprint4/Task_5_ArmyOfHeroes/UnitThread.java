package faang.school.godbless.Sprint4.Task_5_ArmyOfHeroes;

public class UnitThread extends Thread {
    private int unitPower;
    private final Unit unit;

    public UnitThread(Unit unit) {
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
