package faang.school.godbless.army_of_heroes;

public class ManagerThread extends Thread {
    private final Unit unit;
    private int power;
    private String name;

    public ManagerThread(Unit unit) {
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
