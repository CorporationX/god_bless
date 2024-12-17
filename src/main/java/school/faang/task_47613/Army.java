package school.faang.task_47613;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();
    private final List<UnitThread> unitThreads = new ArrayList<>();
    private int result = 0;

    public void addUnit(@NonNull Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        for (Unit unit : units) {
            UnitThread unitThread = new UnitThread(unit);
            unitThreads.add(unitThread);
            System.out.printf("%nЗапущен поток = %s, юнит = %s", unitThread.getName(), unit);
            unitThread.start();
        }

        for (UnitThread unitThread : unitThreads) {
            try {
                unitThread.join();
            } catch (InterruptedException e) {
                System.out.printf("Error in thread = %s", unitThread.getName());
            }
        }

        System.out.println("\nВсе потоки завершили работу\n");

        for (UnitThread unitThread : unitThreads) {
            result += unitThread.getUnitPower();
        }

        return result;
    }
}
