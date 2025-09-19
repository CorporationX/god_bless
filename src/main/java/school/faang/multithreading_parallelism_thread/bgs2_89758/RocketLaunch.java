package school.faang.multithreading_parallelism_thread.bgs2_89758;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static school.faang.multithreading_parallelism_thread.bgs2_89758.Utils.createPrintfWithSuffix;
import static school.faang.multithreading_parallelism_thread.bgs2_89758.Utils.isBetweenClose;

@Getter
@AllArgsConstructor
public class RocketLaunch {

    private static final int ROCKET_LAUNCH_TIME = 1000;
    private static final Printf printf = createPrintfWithSuffix("%n");
    private String name;
    private long launchTime;

    private static List<RocketLaunch> determineLaunchReadyRockets(@NonNull List<RocketLaunch> launches) {
        Map<Long, RocketLaunch> mapRocketLaunch = launches
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        RocketLaunch::getLaunchTime,
                        Function.identity(),
                        (inst1, inst2) -> {
                            printf.print("Запуск %s невозможен, так как на время %d запланирован запуск %s",
                                    inst2, inst2.getLaunchTime(), inst1);
                            return inst1;
                        }
                ));

        List<Long> sortedRocketsByLaunchTime = mapRocketLaunch.keySet().stream()
                .sorted()
                .toList();

        List<List<Long>> prohibitedTimeRangesRocketLaunch = sortedRocketsByLaunchTime.stream()
                .map(launchTime -> List.of(launchTime, launchTime + ROCKET_LAUNCH_TIME))
                .toList();


        List<Long> timeRocketsReadyForLaunch = IntStream.range(1, sortedRocketsByLaunchTime.size())
                .mapToObj(i -> {
                    List<Long> rangeRocketLaunch = prohibitedTimeRangesRocketLaunch.get(i - 1);
                    Long rocketsByLaunchTime = sortedRocketsByLaunchTime.get(i);
                    boolean isInRange = isBetweenClose(rangeRocketLaunch, rocketsByLaunchTime);

                    if (!isInRange) {
                        return rocketsByLaunchTime;
                    }

                    RocketLaunch currentRocketLaunch = mapRocketLaunch.get(rocketsByLaunchTime);
                    RocketLaunch currentStartRocketLaunch = mapRocketLaunch.get(rangeRocketLaunch.get(0));
                    printf.print("Старт вашей ракеты %s невозможен, так как в это время %d, с %d до %d \n " +
                                    "стартует %s в %d",
                            currentRocketLaunch,
                            rocketsByLaunchTime,
                            rangeRocketLaunch.get(0),
                            rangeRocketLaunch.get(1),
                            currentStartRocketLaunch,
                            currentStartRocketLaunch.getLaunchTime());
                    return null;
                })
                .filter(Objects::nonNull)
                .toList();

        return timeRocketsReadyForLaunch.stream()
                .map(mapRocketLaunch::get)
                .toList();
    }

    @SuppressWarnings("checkstyle:CommentsIndentation")
    public static void planRocketLaunches(@NonNull List<RocketLaunch> launches) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            for (RocketLaunch rocket : launches) {
                long delay = rocket.getLaunchTime() - System.currentTimeMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                executor.submit(rocket::launch);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Planning interrupted");
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5,  java.util.concurrent.TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
        }




       /* List<RocketLaunch> rocketsReadyForLaunch = determineLaunchReadyRockets(launches);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        BiFunction<Long, RocketLaunch, Runnable> creationRunnable  = (timeBeforeLaunch, rocketLaunch) -> () -> {
            try {
                Thread.sleep(timeBeforeLaunch);
                rocketLaunch.launch();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.print(e.getMessage());
            }
        };*/


        printf.print("ddd");
        printf.print("ddввввввввввd");

        System.out.printf("ddd");
    }

    @Override
    public String toString() {

        return "RocketLaunch{" +
                "name='" + name + '\'' +
                ", launchTime=" + launchTime +
                '}';
    }

    public int getNextAvailableLaunchTime() {

        return ROCKET_LAUNCH_TIME;
    }

    public void launch() {
        try {
            Thread.sleep(ROCKET_LAUNCH_TIME);
            printf.print("Ракета %d полетела", name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.print(e.getMessage());
        }
    }
}