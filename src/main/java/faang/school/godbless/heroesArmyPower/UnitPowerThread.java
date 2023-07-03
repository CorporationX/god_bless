package faang.school.godbless.heroesArmyPower;

public class UnitPowerThread extends Thread {
    private final Unit unit;

    public UnitPowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
    }

    public int getPower() {
        return unit.getPower();
    }
}
