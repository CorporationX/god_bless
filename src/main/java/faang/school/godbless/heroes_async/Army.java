package faang.school.godbless.heroes_async;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> army = new ArrayList<>();
    private int total;

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (var unit : army) {
            threads.add(new Thread(() -> {
                total += unit.getPower();
            }));
        }
        for (var thread : threads) {
            thread.start();
        }
        for (var thread : threads) {
            thread.join();
        }
        return total;
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }
}
