package school.faang.armyMnM;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Unit> unitList = new ArrayList<>();

    public void addUnit(Unit unit){
        unitList.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Unit unit : unitList){
            PowerCalculator calculator = new PowerCalculator(unit);
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        for (PowerCalculator task : tasks){
            totalPower += task.getPower();
        }

        return totalPower;
    }
}
