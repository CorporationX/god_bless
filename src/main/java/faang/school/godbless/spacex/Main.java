package faang.school.godbless.spacex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = new ArrayList<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        launches.add(new RocketLaunch("Falcon 9", LocalDateTime.now().plusMinutes(1)));
        launches.add(new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusMinutes(2)));
        launches.add(new RocketLaunch("Dragon", LocalDateTime.now().plusMinutes(3)));

        long start = System.currentTimeMillis();

        launches.stream().forEach(launch -> executor.submit(launch));
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finish = System.currentTimeMillis();

        System.out.println("Time spent: " + (finish - start));
    }
}
