package school.faang.sprint_3.task_48027;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        if (unit != null) {
            army.add(unit);
        } else {
            throw new IllegalArgumentException("Unit is null");
        }
    }

    public int calculateTotalPower() {
        int totalPower = 0;

        int totalCount = army.size();
        int threadsCount = 3;
        int batchSize = totalCount / threadsCount;

        List<ArmyCounterThread> counterThreads = new ArrayList<>(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            ArmyCounterThread counterThread = new ArmyCounterThread(army.subList(i * batchSize, (i + 1) * batchSize));
            counterThreads.add(counterThread);
        }

        int remains = totalCount % threadsCount;

        if (remains != 0) {
            counterThreads.add(new ArmyCounterThread(army.subList(batchSize * threadsCount, totalCount)));
        }

        counterThreads.forEach(Thread::start);

        counterThreads.forEach(armyCounterThread -> {
            try {
                armyCounterThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        for (ArmyCounterThread counterThread : counterThreads) {
            totalPower += counterThread.getSumPower();
        }

        return totalPower;
    }
}
