package faang.school.godbless.task.multithreading.might.and.magic;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Army {
    private final Logger logger = LoggerFactory.getLogger(Army.class);
    private final List<Character> army;

    public void addUnit(Character unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(army.size());
        List<Future<Integer>> futures = new ArrayList<>();
        IntStream.range(0, army.size())
                .forEach(i -> futures.add(executorService.submit(() -> army.get(i).getPower())));
        executorService.shutdown();
        return IntStream.range(0, futures.size())
                .map(i -> {
                    try {
                        return futures.get(i).get();
                    } catch (InterruptedException | ExecutionException e) {
                        logger.error("Error: {}", e.getMessage());
                        throw new RuntimeException(e);
                    }
                })
                .sum();
    }
}
