package faang.school.godbless.multithreadingS4.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> army;

    public Army() {
        army = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        List<Thread> threads = army.stream().map(unit -> new Thread(new CounterPower(unit))).toList();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.printf("%s has been interrupted", thread.getName());
                e.getStackTrace();
            }
        });

        return CounterPower.getFullPowerArmy();
    }
}
