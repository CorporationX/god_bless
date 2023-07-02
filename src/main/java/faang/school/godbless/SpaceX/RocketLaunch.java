package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class RocketLaunch implements Runnable {
    private String name;
    private LocalDateTime date;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1500);
        System.out.printf("%s rocket has launched\n", name);
    }

    @SneakyThrows
    public static void planRocketLaunches(List<RocketLaunch> launches) {
        var order = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getDate))
                .toList();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        order.forEach(executor::submit);
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
