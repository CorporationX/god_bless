package school.faang.sprint3.bjs248085;

import java.util.ArrayList;
import java.util.List;

class Army {
    private final List<Warrior> warriors = new ArrayList<>();

    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Warrior warrior : warriors) {
            PowerCalculator calculator = new PowerCalculator(warrior);
            tasks.add(calculator);

            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }
}