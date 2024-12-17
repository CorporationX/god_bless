package school.faang.task_48006;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public static int calculateTotalPower() {

        int totalPower = 0;

        List<Thread> threads = new ArrayList<>();
        List<CalculatePower> task = new ArrayList<>();

        CalculatePower power;
        Thread thread;

        for (Unit unit : units) {
            power = new CalculatePower(unit);
            task.add(power);
            thread = new Thread(power);
            threads.add(thread);
            thread.start();
        }

        for (Thread countThread : threads) {
            try {
                countThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (CalculatePower powers : task) {
            totalPower += powers.getPower();
        }
        return totalPower;
    }
}