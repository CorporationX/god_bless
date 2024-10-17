package school.faang.thredHeroesSwordAndMagic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {

    List<Unit> units;
    List<Thread> threads = new ArrayList<>();
    int totalPower = 0;

    public Army() {
        this.units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : units) {
            Thread thread = new Thread(() -> {
                synchronized (this) {
                    totalPower += unit.getTotalPower();
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower;
    }
}
