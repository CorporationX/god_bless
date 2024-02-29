package faang.school.godbless.heroes_magic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> unitsList = new ArrayList<>();

    public void addUnit(Unit unit) {
        unitsList.add(unit);
    }

    public int calculateTotalPower()  {
        List<UnitPowerThread> unitPowerThreads = new ArrayList<>();
        int totalPower = 0;

        for (Unit unit : unitsList) {
            UnitPowerThread tread = new UnitPowerThread(unit);
            tread.start();
            unitPowerThreads.add(tread);
        }

        for (UnitPowerThread thread : unitPowerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            totalPower += thread.getPower();
        }

        return totalPower;
    }


}
