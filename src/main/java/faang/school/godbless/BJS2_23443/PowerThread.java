package faang.school.godbless.BJS2_23443;

public class PowerThread extends Thread{

    private final Unit unit;
    private int power;

    @Override
    public void run() {
        power = unit.getPower();
    }

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    public int getPower() {
        return power;
    }

}
