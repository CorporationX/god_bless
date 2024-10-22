package school.faang.thread2;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Soldier> soldierList = new ArrayList<>();

    public void addSoldier(Soldier soldier) {
        soldierList.add(soldier);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();
        for (Soldier soldier : soldierList) {
            PowerCalculator calculator = new PowerCalculator(soldier);
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
