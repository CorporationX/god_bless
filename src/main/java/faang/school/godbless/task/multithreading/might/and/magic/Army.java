package faang.school.godbless.task.multithreading.might.and.magic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Army {
    private static final int THREAD_POOL_LIMIT = 3;

    private final List<CompletableFuture<Integer>> futures = new ArrayList<>();
    private final Map<String, List<Character>> army = new HashMap<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);

    public void addUnits(Character unit) {
        List<Character> units = army.computeIfAbsent(unit.getType(), k -> new ArrayList<>());
        units.add(unit);
    }

    public int calculateTotalPower() {
        futures.addAll(getFutures());
        executor.shutdown();
        return calculate();
    }

    private List<CompletableFuture<Integer>> getFutures() {
        return army.values()
                .stream()
                .map(this::startThread)
                .toList();
    }

    private CompletableFuture<Integer> startThread(List<Character> units) {
        return CompletableFuture.supplyAsync(() -> {
            int sum = units.stream()
                    .map(Character::getPower)
                    .mapToInt(Integer::intValue)
                    .sum();
            log.info("Power sum of {}, even: {} ", units.get(0).getType(), sum);
            return sum;
        }, executor);
    }

    private int calculate() {
        try {
            return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                    .thenApply(v -> sumIntInFuture())
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error: {}", e.getMessage());
            return 0;
        }
    }

    private int sumIntInFuture() {
        return futures.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
