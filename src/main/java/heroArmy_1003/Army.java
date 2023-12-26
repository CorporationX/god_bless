package heroArmy_1003;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {
    private List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<UnitThread> mageThread = new ArrayList<>();
        List<UnitThread> archerThread = new ArrayList<>();
        List<UnitThread> swordsmanThread = new ArrayList<>();

        for (Unit unit : units) {
            UnitThread unitThread = new UnitThread(unit);
            if (unit.getName().equals("Archer")) {
                archerThread.add(unitThread);
            } else if (unit.getName().equals("Mage")) {
                mageThread.add(unitThread);
            } else if (unit.getName().equals("Swordsman")) {
                swordsmanThread.add(unitThread);
            }
            unitThread.start();
        }

        int totalMagePower = getPowerSum(mageThread);
        int totalArcherPower = getPowerSum(archerThread);
        int totalSwordsmanPower = getPowerSum(swordsmanThread);

        System.out.println("Mage = " + totalMagePower);
        System.out.println("Archer = " + totalArcherPower);
        System.out.println("Swordsman = " + totalSwordsmanPower);

        return totalMagePower + totalArcherPower + totalSwordsmanPower;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    private int getPowerSum(List<UnitThread> threads) throws InterruptedException {
        int totalPower = 0;
        for (UnitThread thread : threads) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }
}