package school.faang.task47604;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Warrior> army = new ArrayList<>();
    private int totalPower;

    public int calculateTotalPower() throws InterruptedException {

        List<PowerThread> tasks = new ArrayList<>();

        for (var warrior : army) {
            PowerThread powerTask = new PowerThread(warrior, warrior.getPower());
            tasks.add(powerTask);

            powerTask.start();
        }

        for (var task : tasks) {
            totalPower += task.getPower();
            task.join();
        }

        return totalPower;
    }

    public void addUnit(Warrior warrior) {
        if (warrior == null) {
            throw new IllegalArgumentException("warrior can`t be null");
        }
        army.add(warrior);
    }
}
