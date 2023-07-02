package faang.school.godbless.Sprint4.task5;

public class PowerThread extends Thread {
    private final Unit unit;
    private int power;
    private String name;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
        name = unit.getName();
    }

    public int getPower() {
        return power;
    }

    public String getNameUnit() {
        return name;
    }
}
