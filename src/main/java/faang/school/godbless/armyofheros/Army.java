package faang.school.godbless.armyofheros;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    private final List<PowerCalculatorThread> swordsmanThread = new ArrayList<>();
    private final List<PowerCalculatorThread> archerThread = new ArrayList<>();
    private final List<PowerCalculatorThread> mageThread = new ArrayList<>();

    public void addUnit(@NonNull Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        for(Unit unit : units) {
            if (unit instanceof Mage) {
                PowerCalculatorThread powerThread = new PowerCalculatorThread(unit);
                mageThread.add(powerThread);
                powerThread.start();
            } else if (unit instanceof Archer) {
                PowerCalculatorThread powerThread = new PowerCalculatorThread(unit);
                archerThread.add(powerThread);
                powerThread.start();
            } else if (unit instanceof Swordsman) {
                PowerCalculatorThread powerThread = new PowerCalculatorThread(unit);
                swordsmanThread.add(powerThread);
                powerThread.start();
            }
        }
        int totalMagePower = getPowerSum(mageThread);
        int totalArcherPower = getPowerSum(archerThread);
        int totalSwordsmanPower = getPowerSum(swordsmanThread);

        return totalArcherPower + totalMagePower + totalSwordsmanPower;
    }

    private int getPowerSum(List<PowerCalculatorThread> units) throws InterruptedException {
        int sum = 0;
        for (PowerCalculatorThread unitThread : units) {
            unitThread.join();
            sum += unitThread.getPower();
        }
        return sum;
    }
}
