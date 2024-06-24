package BJS2_11081;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        List<ArmyThread> armyThreads = new ArrayList<>();

        units.forEach(unit -> {
            ArmyThread thread = new ArmyThread(unit);
            armyThreads.add(thread);
            thread.start();
        });

        armyThreads.forEach(armyThread -> {
            try {
                armyThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return powerSum(armyThreads);
    }

    private int powerSum(List<ArmyThread> armyThreads) {
        return armyThreads.stream()
                .map(ArmyThread::getUnitPower)
                .reduce(Integer::sum)
                .orElse(0);

    }
}
