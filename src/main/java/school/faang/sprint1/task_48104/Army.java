package school.faang.sprint1.task_48104;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    private int totalPower = 0;

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();
        try {

            for (Unit unit : units) {
                PowerCalculator calculator = new PowerCalculator(unit);
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
        } catch (InterruptedException e) {
            System.out.println("поток прирвался");
        }
        return totalPower;
    }
}
