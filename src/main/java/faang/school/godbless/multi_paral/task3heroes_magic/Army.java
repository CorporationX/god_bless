package faang.school.godbless.multi_paral.task3heroes_magic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Army {
    private List<Unit> units = new ArrayList<>();
    private int totalPower = 0;

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (Unit unit : units) {
            Thread thread = new Thread(() -> {
                synchronized (this) {
                    totalPower += unit.getPower();
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

    //Настойчиво рекомендовал Влад
    public int calculateTotalPower2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(units.size());

        for (Unit unit : units) {
            executorService.execute(() -> {
                synchronized (this) {
                    totalPower += unit.getPower();
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);

        return totalPower;
    }


}
