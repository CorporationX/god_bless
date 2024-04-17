package faang.school.godbless.parallelism.heroesOfMightAndMagic;

public class PowerCalculationThread extends Thread {
    private static int totalPower = 0;
    private final ArmyUnit armyUnit;

    public static int getTotalPower() {
        return totalPower;
    }

    public PowerCalculationThread(ArmyUnit armyUnit) {
        this.armyUnit = armyUnit;
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        totalPower += armyUnit.getPower();
    }
}
