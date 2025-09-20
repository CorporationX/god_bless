package school.faang.multithreading_parallelism_thread.bgs2_89758;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static school.faang.multithreading_parallelism_thread.bgs2_89758.Utils.createPrintfWithSuffix;
import static school.faang.multithreading_parallelism_thread.bgs2_89758.Utils.runAwaitAndShutdown;
import static school.faang.multithreading_parallelism_thread.bgs2_89758.Utils.runWithThreadErrorHandling;

@Getter
@AllArgsConstructor
public class RocketLaunch {

    private static final int ROCKET_LAUNCH_TIME = 1000;
    private static final Printf printf = createPrintfWithSuffix("%n");
    private static final BiFunction<Long, RocketLaunch, Runnable> creationRunnable =
            (timeBeforeLaunch, rocketLaunch) -> () -> {
                try {
                    Thread.sleep(timeBeforeLaunch);
                    rocketLaunch.launch();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.print(e.getMessage());
                }
            };
    private String name;
    private Long launchTime;

    public static void planRocketLaunches(@NonNull List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

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

        List<List<Long>> rocketsReadyForLaunch = new ArrayList<>();

        IntStream.range(0, sortedRocketsByLaunchTime.size())
                .forEach(i -> {
                    Long currentTime = sortedRocketsByLaunchTime.get(i);
                    Long rocketsByLaunchTime;
                    RocketLaunch currentRocketLaunch = mapRocketLaunch.get(currentTime);
                    if (i == 0) {
                        rocketsReadyForLaunch.add(List.of(currentTime, currentRocketLaunch.getLaunchTime()));
                    } else {
                        rocketsByLaunchTime = rocketsReadyForLaunch.get(rocketsReadyForLaunch.size() - 1).get(0);
                        long diff = currentTime
                                - rocketsByLaunchTime
                                - ROCKET_LAUNCH_TIME;

                        if (diff > 0) {
                            rocketsReadyForLaunch.add(List.of(currentTime, diff));
                        } else {
                            RocketLaunch currentStartRocketLaunch = mapRocketLaunch.get(rocketsByLaunchTime);
                            printf.print("Старт вашей ракеты %s невозможен, так как в это время %d с %d по %d, %n " +
                                            "все еще выполняется старт %s",
                                    currentRocketLaunch,
                                    currentRocketLaunch.getLaunchTime(),
                                    rocketsByLaunchTime,
                                    rocketsByLaunchTime + ROCKET_LAUNCH_TIME,
                                    currentStartRocketLaunch);
                        }
                    }
                });

        runAwaitAndShutdown(executor, () -> {
            List<Runnable> listTasks = rocketsReadyForLaunch.stream()
                    .map(item -> {
                        RocketLaunch rocketLaunch1 = mapRocketLaunch.get(item.get(0));
                        return creationRunnable.apply(item.get(1), rocketLaunch1);
                    })
                    .toList();

            listTasks.stream()
                    .map(executor::submit)
                    .forEach(future -> runWithThreadErrorHandling(future::get));
        });
    }

    public void launch() {
        runWithThreadErrorHandling(() -> {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
            String now = LocalTime.now().format(fmt);

            printf.print("%s готовится к запуску ракета %s", now, name);

            Thread.sleep(ROCKET_LAUNCH_TIME);
            now = LocalTime.now().format(fmt);

            printf.print("Старт %s Ракета %s полетела", now, name);
        });
    }

    @Override
    public String toString() {
        return "RocketLaunch{" +
                "name='" + name + '\'' +
                ", launchTime=" + launchTime +
                '}';
    }
}