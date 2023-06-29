package faang.school.godbless.Sprint_3.Multythreading.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime time;

    public void launch() throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Go!");
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) throws RuntimeException{
        List<RocketLaunch> sortedLaunches = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getTime))
                .toList();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (RocketLaunch l : sortedLaunches){
            executor.execute(()-> {
                try {
                    l.launch();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
