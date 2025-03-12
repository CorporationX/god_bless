package school.faang.task60814;

import lombok.extern.slf4j.Slf4j;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class SpaceX {
    private static final long RANDOM_NUMBER_LAUNCHES = new Random().nextLong(1, 301);
    public static final int RANGE_START = 0;
    public static final int LAUNCHES_COUNT = 45;

    private static final Random RANDOM = new Random();

    private static final List<RocketLaunch> launches = IntStream.range(RANGE_START, RANGE_START + LAUNCHES_COUNT)
            .mapToObj(num ->
                    new RocketLaunch("launche " + num,
                            RANDOM.nextLong(0, RANDOM_NUMBER_LAUNCHES)))
            .toList();

    private void planRocketLaunches(List<RocketLaunch> launches) {
        log.debug("Запуск планирования ракетных запусков. Количество запусков: {}", launches.size());
        final long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        launches.stream()
                .sorted(Comparator.comparingLong(RocketLaunch::launchTime))
                .forEach(launch -> executor.submit(launch::launch));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(LAUNCHES_COUNT + 1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Остановили принудительно Пул потоков {}", executor);
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        final long resultTime = System.currentTimeMillis() - startTime;

        log.debug("Программа выполнилась за {} ms", resultTime);
    }

    public static void main(String[] args) {
        SpaceX spaceX = new SpaceX();
        spaceX.planRocketLaunches(launches);
    }
}