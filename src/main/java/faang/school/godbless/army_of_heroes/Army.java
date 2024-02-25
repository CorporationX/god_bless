package faang.school.godbless.army_of_heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();
        /*idea предложила AtomicInteger но я не понял почему с int не сработвало,
          здесь (totalPower.addAndGet(unit.getPower()))) totalPower высвечивал*/
        /*по поиска в гугле написано cannot be the replacement, однако как раз таки произошел replacement
           An AtomicInteger is used in applications such as atomically incremented counters,
            and cannot be used as a replacement for an Integer .*/

        List<Thread> threads = new ArrayList<>();
        for (Unit unit : units) {
            threads.add(new Thread(() -> totalPower.addAndGet(unit.getPower())));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower.get();
    }
}
