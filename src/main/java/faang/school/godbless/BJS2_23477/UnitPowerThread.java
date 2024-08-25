package faang.school.godbless.BJS2_23477;

public class UnitPowerThread extends Thread {

    private final Unit unit;
    private final int[] result;

    public UnitPowerThread(Unit unit, int[] result) {
        this.unit = unit;
        this.result = result;
    }

    @Override
    public void run() {
        result[0] += unit.getPower();
    }
}
