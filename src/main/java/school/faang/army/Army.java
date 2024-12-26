package school.faang.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Person> personList = new ArrayList<>();

    public void addUnit(Person person) {
        personList.add(person);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        for (Person person : personList) {
            PowerCalculator powerCalculator = new PowerCalculator(person);
            tasks.add(powerCalculator);
            Thread thread = new Thread(powerCalculator);
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
