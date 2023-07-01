package Multithreading.bc2409;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String name;
    private LocalDateTime time;

    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Rocket started");
    }

    public void planRocketLaunches(List<RocketLaunch> rockets){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }

}
