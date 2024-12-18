package school.faang.task_47997;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Warrior> warriors = new ArrayList<>();

    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        for (Warrior warrior : warriors) {
            WarriorThread thread = new WarriorThread(warrior);
            thread.start();
            totalPower += warrior.getPower();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted: " + e.getMessage());
            }
        }
        return totalPower;
    }
}
