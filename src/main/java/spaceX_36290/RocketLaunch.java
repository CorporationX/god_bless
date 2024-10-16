package spaceX_36290;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private final String name;
    private final LocalDateTime launchTime;

    public static void main(String[] args) {

        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Falcon 1", LocalDateTime.now().plusSeconds(2)),
                new RocketLaunch("Falcon 9", LocalDateTime.now().plusSeconds(5)),
                new RocketLaunch("Falcon Heavy", LocalDateTime.now().plusSeconds(10))
        );

        planRocketLaunches(launches);
    }

    public Runnable launch() {
        try {
            int delay = 1000;
            Thread.sleep(delay);
            System.out.println("Рокета " + name + " запускается!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void planRocketLaunches(List<RocketLaunch> launches){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(RocketLaunch launch : launches){
            try {
                executorService.execute(launch.launch());
                executorService.awaitTermination(launch.getLaunchTime().getSecond(), TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
