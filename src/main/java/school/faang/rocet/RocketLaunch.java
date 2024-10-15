package school.faang.rocet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@NoArgsConstructor
public class RocketLaunch {
    private String name;
    private int launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " launched at " + launchTime);
    }

    public void planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        launches.forEach(r -> {
            executor.execute(() -> {
                try {
                    Thread.sleep(r.launchTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                r.launch();
            });
        });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("Что то пошло не так");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Общее время выполнения: " + (endTime - startTime) + " миллисекунд");
    }
}

