package school.faang.BJS235871;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Character> army = new ArrayList<>();

    public void addUnit(Character character) {
        army.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        int threadPool = 5;
        AtomicInteger sumPower = new AtomicInteger();
        ExecutorService service = Executors.newFixedThreadPool(threadPool);
        for (Character character : army) {
            service.submit(() -> sumPower.addAndGet(character.getPower()));
        }
        if (!service.awaitTermination(threadPool, TimeUnit.SECONDS)) {
            service.shutdown();
        }
        return sumPower.get();
    }
}