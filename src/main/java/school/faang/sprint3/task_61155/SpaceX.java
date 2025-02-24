package school.faang.sprint3.task_61155;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SpaceX {
    private static final String LOG_FORM = "Остановили принудительно Пул потоков {}";
    private static final Random RANDOM = new Random();
    private static final int MIN_LAUNCHES = 0;
    private static final int COUNT_LAUNCHES = 20;
    private static final int MAX_LAUNCH_TIME = 1000;

    private static final List<RocketLaunch> LAUNCHES = IntStream.range(MIN_LAUNCHES, MIN_LAUNCHES + COUNT_LAUNCHES)
            .mapToObj(num -> new RocketLaunch("launch " + num, RANDOM.nextLong(0, MAX_LAUNCH_TIME)))
            .toList();

    public static void main(String[] args) {
        SpaceX spaceX = new SpaceX();
        spaceX.planRocketLaunches(LAUNCHES);
    }

    private void planRocketLaunches(List<RocketLaunch> launches) {
        final long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        launches.stream()
                .sorted(Comparator.comparingLong(RocketLaunch::launchTime))
                .forEach(launch -> executor.submit(launch::launch));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(COUNT_LAUNCHES + 1, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info(LOG_FORM, executor);
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("{} c исключением", LOG_FORM, e);
        }

        long resultTime = System.currentTimeMillis() - startTime;
        log.debug("Полеты рассчитались за {} ms", resultTime);
    }
}
