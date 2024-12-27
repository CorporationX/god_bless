package school.faang.task_48486;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private static final int ARCHER_QUANTITY = 100;
    private static final int SWORDSMAN_QUANTITY = 100;
    private static final int MAGE_QUANTITY = 100;

    private final List<Character> mages = Collections.nCopies(MAGE_QUANTITY, new Mage());
    private final List<Character> swordsmen = Collections.nCopies(SWORDSMAN_QUANTITY, new Swordsman());
    private final List<Character> archers = Collections.nCopies(ARCHER_QUANTITY, new Archer());

    @SneakyThrows
    public int calculateTotalPower() {
        List<Character> army = new ArrayList<>();
        army.addAll(mages);
        army.addAll(swordsmen);
        army.addAll(archers);
        AtomicInteger totalPower = new AtomicInteger();

        int maxThreads = Runtime.getRuntime().availableProcessors();
        Semaphore semaphore = new Semaphore(maxThreads);

        List<Thread> threads = new ArrayList<>();
        for (Character character : army) {
            semaphore.acquire();
            Thread thread = new Thread(() -> {
                try {
                    totalPower.addAndGet(character.getPower());
                } finally {
                    semaphore.release();
                }

            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower.get();
    }
}
