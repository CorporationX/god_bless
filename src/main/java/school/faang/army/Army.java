package school.faang.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> list = new ArrayList<>();

    public void addUnit(Unit unit) {
        list.add(unit);
        System.out.println(list.toString());

    }

    public int calculateTotalPower() throws InterruptedException {
        int sum = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit list1 : list) {
            PowerCalculator powerCalculator = new PowerCalculator(list1);
            Thread thread = new Thread(powerCalculator);
            tasks.add(powerCalculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator task : tasks) {
            sum += task.getPower();

        }
        return sum;
    }
}
