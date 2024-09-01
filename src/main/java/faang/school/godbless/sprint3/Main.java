package faang.school.godbless.sprint3;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = LongStream.range(1L, 6L)
                .mapToObj(i -> new RocketLaunch("Launch X_" + i, LocalDateTime.now().plusSeconds(5L + i)))
                .toList();
        planRocketLaunches(launches);
    }

    private static void planRocketLaunches(List<RocketLaunch> launchList) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<CompletableFuture<Void>> launchFutures = launchList.stream()
                .map(launch -> CompletableFuture.runAsync(launch::start, executor))
                .toList();

        executor.shutdown();
        CompletableFuture.allOf(launchFutures.toArray(CompletableFuture[]::new)).join();
        double totalSeconds = (double)(System.currentTimeMillis() - startTime) / 1000;

        System.out.println("All launches took: " + totalSeconds + " seconds.");
        System.out.println("================================================");
    }
}
