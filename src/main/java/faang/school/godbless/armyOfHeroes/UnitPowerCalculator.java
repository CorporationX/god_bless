package faang.school.godbless.armyOfHeroes;

public class UnitPowerCalculator extends Thread {
    private Unit unit;
    private int power;

    public UnitPowerCalculator(Unit unit) {
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
