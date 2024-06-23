package faang.school.godbless.multithreading.parallelism.armyOfHeroes;

public class UnitThread extends Thread {
    private final Unit unit;
    private int power;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        System.out.println("Thread for " + unit.getClass().getSimpleName() + " started");
        power = unit.getPower();
    }

    public int getPower() {
        return power;
    }
}
