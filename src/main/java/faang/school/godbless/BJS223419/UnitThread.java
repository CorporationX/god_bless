package faang.school.godbless.BJS223419;

public class UnitThread extends Thread {
    private final Unit unit;
    private int power;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
