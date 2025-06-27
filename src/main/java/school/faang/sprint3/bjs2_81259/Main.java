package school.faang.sprint3.bjs2_81259;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //long star = System.currentTimeMillis();
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(new RocketLaunch("Launch 1", LocalDateTime.now().plusSeconds(3)));
        launches.add(new RocketLaunch("Launch 2", LocalDateTime.now().plusSeconds(1)));
        launches.add(new RocketLaunch("Launch 3", LocalDateTime.now().plusSeconds(5)));
        launches.add(new RocketLaunch("Launch 4", LocalDateTime.now().plusSeconds(8)));
        launches.add(new RocketLaunch("Launch 5", LocalDateTime.now().plusSeconds(2)));
        long startTime = System.currentTimeMillis();
        planRocketLaunches(launches);
        long endTime = System.currentTimeMillis(); // Конец времени
        System.out.printf("Total execution time: %d ms\n", endTime - startTime);
        //long end = System.currentTimeMillis();
        //System.out.printf("Время выполнения программы: %s ms\n", end - star);
        //todo иначе ошибка code style: Distance between variable 'star' declaration and its first usage is 7,
        // but allowed 3
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) {
        launches.sort(Comparator.comparing(RocketLaunch::getLaunchTime));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            for (RocketLaunch rocket : launches) {
                long launchMillis = rocket.getLaunchTime()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
                        .toEpochMilli();
                long delay = launchMillis - System.currentTimeMillis();
                if (delay > 0) {
                    Thread.sleep(delay);
                }
                executor.execute(rocket::launch);
            }
        } catch (InterruptedException | RuntimeException e) {
            Thread.currentThread().interrupt();
            System.out.println("launching interrupted");
        } finally {
            ThreadUtils.gracefullyShutdown(executor);
        }
    }
}
