package faang.school.godbless.Sprint_4.Multithreading_Parallelism.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    public void launch() throws RuntimeException {
        try {
            Thread.sleep(1000);
            System.out.printf("%s GO!\n", name);
        } catch (InterruptedException e) {
            System.out.println("launch error");
        }
    }

    public static void planRocketLaunches(List<RocketLaunch> launches) throws RuntimeException{
        LocalDateTime now = LocalDateTime.now();
        List<RocketLaunch> sortedLaunches = launches.stream()
                .sorted(Comparator.comparing(RocketLaunch::getTime))
                .toList();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (RocketLaunch l : sortedLaunches){
            long dif = Math.abs(ChronoUnit.MILLIS.between(l.getTime(), LocalDateTime.now()));
            System.out.println(dif);
            executor.execute(()-> {
                try {
                    Thread.sleep(dif);
                    l.launch();
                } catch (RuntimeException e) {
                    System.out.println("planRocketLaunches Error");
                } catch (InterruptedException e) {
                    System.out.println("Sleep in planRocketLaunches Error");
                }
            });
        }
        try {
            executor.shutdown();
            executor.awaitTermination(100000, TimeUnit.MILLISECONDS);
            executor.shutdownNow();
            System.out.println("Time: " + ChronoUnit.SECONDS.between(now, LocalDateTime.now()));
        } catch (InterruptedException e) {
            System.out.println("Wait Error");
        }


    }
}
