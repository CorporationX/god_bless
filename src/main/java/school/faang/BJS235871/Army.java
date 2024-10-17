package school.faang.BJS235871;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Character> army = new ArrayList<>();
    private final static int THREAD_POOL = 5;

    public void addUnit(Character character) {
        army.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger sumPower = new AtomicInteger();
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL);
        for (Character character : army) {
            service.submit(() -> sumPower.addAndGet(character.getPower()));
        }
        if (!service.awaitTermination(THREAD_POOL, TimeUnit.SECONDS)) {
            service.shutdown();
        }
        return sumPower.get();
    }
}