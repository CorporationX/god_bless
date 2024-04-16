package faang.school.godbless.parallelhomm;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Warrior> warriors;

    public Army() {
        this.warriors = new ArrayList<>();
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<WarriorThread> threads = new ArrayList<>();
        for (Warrior warrior : warriors) {
            WarriorThread thread = new WarriorThread(warrior);
            threads.add(thread);
            thread.start();
        }

        for (WarriorThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return totalPower;
    }

    public void addUnit(Warrior warrior) {
        warriors.add(warrior);
    }
}
