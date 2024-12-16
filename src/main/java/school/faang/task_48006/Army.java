package school.faang.task_48006;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public static int calculateTotalPower() throws InterruptedException {

        int totalPower = 0;

        List<Thread> threads = new ArrayList<>();
        List<CalculatePower> task = new ArrayList<>();

        for (Unit unit : units) {
            CalculatePower power = new CalculatePower(unit);
            task.add(power);
            Thread thread = new Thread(power);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (CalculatePower powers : task) {
            totalPower += powers.getPower();
        }
        return totalPower;
    }
}
