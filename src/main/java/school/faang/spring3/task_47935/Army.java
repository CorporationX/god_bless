package school.faang.spring3.task_47935;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {

    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerThread> tasks = new ArrayList<>();
        PowerThread powerThread;
        Thread thread;
        for (Unit unit : units) {
            powerThread = new PowerThread(unit);
            tasks.add(powerThread);
            thread = new Thread(powerThread);
            threads.add(thread);
            thread.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        for (PowerThread task : tasks) {
            totalPower += task.getPower();
        }
        return totalPower;
    }
}
