package school.faang.task_47997;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> warriors = new ArrayList<>();

    public void addWarrior(Unit warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        WarriorThread thread;
        for (Unit unit : warriors) {
            thread = new WarriorThread(unit);
            thread.start();
            totalPower += unit.getPower();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted: " + e.getMessage());
            }
        }
        return totalPower;
    }
}
