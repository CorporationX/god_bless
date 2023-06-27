package faang.school.godbless.spacex_program;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

@AllArgsConstructor
@Getter
public class RocketLaunch implements Runnable {
    private String launchName;
    private LocalDateTime launchTime;

    @SneakyThrows
    public void launch() {
        Thread.sleep(1000);
        System.out.println(launchName + " was launched at " + launchTime);
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(RocketLaunch launch : launches) {
            executorService.submit(launch);
        }
        executorService.shutdown();

        executorService.awaitTermination(5, SECONDS);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " milliseconds");
    }

    @Override
    public void run() {
        launch();
    }

    public static void main(String[] args) throws InterruptedException {
        List<RocketLaunch> launches = new ArrayList<>();
        LocalDateTime launchTime = LocalDateTime.now();
        RocketLaunch rocketLaunch1 = new RocketLaunch("rocket-1", launchTime);
        RocketLaunch rocketLaunch2 = new RocketLaunch("rocket-2", launchTime.plusSeconds(2));
        RocketLaunch rocketLaunch3 = new RocketLaunch("rocket-3", launchTime.plusSeconds(3));
        launches.add(rocketLaunch1);
        launches.add(rocketLaunch2);
        launches.add(rocketLaunch3);

        planRocketLaunches(launches);

    }
}
