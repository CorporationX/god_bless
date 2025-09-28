package bjs2_89586;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final int THREAD_POOL_SIZE = 2;

    private final Map<Knight, List<Trial>> knightTrials = new HashMap<>();

    public void addKnightWithTrials(Knight knight, List<Trial> trials) {
        knightTrials.put(knight, trials);
    }

    public void startTournament() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        knightTrials.values().stream()
                .flatMap(List::stream)
                .forEach(executorService::submit);

        ExecutorUtils.gracefullyShutdown(executorService);
    }


}