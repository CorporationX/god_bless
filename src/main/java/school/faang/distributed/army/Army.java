package school.faang.distributed.army;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@AllArgsConstructor
public class Army {
    private static final int NUMBER_OF_BATCH = 4;

    private final List<Creation> creations = new ArrayList<>();

    public void addUnit(Creation unit) {
        creations.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_BATCH);
        List<Future<Integer>> futures = new ArrayList<>();

        int batchSize = (int) Math.ceil((double) creations.size() / NUMBER_OF_BATCH);
        for (int i = 0; i < creations.size(); i += batchSize) {
            int startIndx = i * batchSize;
            int endIndx = Math.min(i + batchSize, creations.size());

            if (startIndx < endIndx) {
                List<Creation> subList = creations.subList(startIndx, endIndx);
                futures.add(executor.submit(() -> subList.stream()
                        .mapToInt(Creation::getPower)
                        .sum()
                ));
            }
        }

        executor.shutdown();
        int totalPower = 0;
        for (Future<Integer> future : futures) {
            totalPower += future.get();
        }
        return totalPower;
    }
}
