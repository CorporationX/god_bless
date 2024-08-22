package faang.school.godbless.hsam;

public class PowerThread extends Thread {

    private Unit unit;
    private int power;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }

    public int getPower(Unit unit) {
        return power;
    }
}
