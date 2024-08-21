package faang.school.godbless.BJS223419;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
    private final List<Unit> units;

    List<UnitThread> mageThreads = new ArrayList<>();
    List<UnitThread> archerThreads = new ArrayList<>();
    List<UnitThread> swordsmanThreads = new ArrayList<>();

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Unit unit : units) {
            if (unit.isMage()) {
                UnitThread unitThread = new UnitThread(unit);
                mageThreads.add(unitThread);
                unitThread.start();
            } else if (unit.isArcher()) {
                UnitThread unitThread = new UnitThread(unit);
                archerThreads.add(unitThread);
                unitThread.start();
            } else if (unit.isSwordsman()) {
                UnitThread unitThread = new UnitThread(unit);
                swordsmanThreads.add(unitThread);
                unitThread.start();
            }
        }

        int totalMagePower = getPowerSun(mageThreads);
        int totalArcherPower = getPowerSun(archerThreads);
        int totalSwordsmanPower = getPowerSun(swordsmanThreads);

        System.out.println("Power mages = " + totalMagePower);
        System.out.println("Power archers = " + totalArcherPower);
        System.out.println("Power swordsmans = " + totalSwordsmanPower);

        return totalMagePower + totalArcherPower + totalSwordsmanPower;
    }

    private int getPowerSun(List<UnitThread> units) throws InterruptedException {
        int totalPower = 0;
        for (UnitThread mageThread : units) {
            mageThread.join();
            totalPower += mageThread.getPower();
        }
        return totalPower;
    }
}
