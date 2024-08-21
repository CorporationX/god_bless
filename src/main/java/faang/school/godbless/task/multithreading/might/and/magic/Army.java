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
    private final List<CompletableFuture<Integer>> futures = new ArrayList<>();
    private final Map<Character, List<Character>> army = new HashMap<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public void addUnits(Character unit) {
        List<Character> units = army.computeIfAbsent(unit, k -> new ArrayList<>());
        units.add(unit);
    }

    public int calculateTotalPower() {
        futures.addAll(
                army.values()
                        .stream()
                        .map(this::startThread)
                        .toList());
        executor.shutdown();
        return calculate();
    }

    private CompletableFuture<Integer> startThread(List<Character> units) {
        return CompletableFuture.supplyAsync(() -> units
                .stream()
                .map(Character::getPower)
                .mapToInt(Integer::intValue)
                .sum(), executor);
    }

    private int calculate() {
        try {
            return CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                    .thenApply(v -> futures.stream()
                            .map(CompletableFuture::join)
                            .mapToInt(Integer::intValue)
                            .sum())
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error: {}", e.getMessage());
            return 0;
        }
    }
}
