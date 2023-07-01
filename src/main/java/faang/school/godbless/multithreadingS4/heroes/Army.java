package faang.school.godbless.multithreadingS4.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private int armyPower;
    private List<Unit> army;

    public Army() {
        army = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        List<CounterPower> threads = army.stream().map(CounterPower::new).toList();

        threads.forEach(Thread::start);

        threads.forEach(counterPower -> {
            try {
                counterPower.join();
                armyPower += counterPower.getPowerUnit(); // Почему я могу так сделать в лямбда?
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted", counterPower.getName());
                e.getStackTrace();
            }
        });

        return armyPower;
    }
}
