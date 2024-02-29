package faang.school.godbless.heroes_magic;

public class UnitPowerThread extends Thread {
    private final Unit unit;
    private int power;

    public UnitPowerThread(Unit unit) {
        this.unit = unit;
    }

    public int getPower() {
        return power;
    }

    public void run() {
        power = unit.getPower();
    }
}
