package school.faang.sprint3.task_47805;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> units = new ArrayList<>();

    public void addUnit(@NonNull Character character) {
        units.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<UnitThread> unitThreads = new ArrayList<>();

        for (Character unit : units) {
            UnitThread thread = new UnitThread(unit);
            unitThreads.add(thread);
            thread.start();
        }

        for (UnitThread thread : unitThreads) {
            thread.join();
        }

        int totalPower = 0;
        for (UnitThread t : unitThreads) {
            totalPower += t.getPower();
        }
        return totalPower;
    }
}
