package spaceX_36290;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class RocketLaunch {
    private String name;
    private int launchTime;

    public RocketLaunch(String name, int launchTime) {
        this.name = name;
        this.launchTime = launchTime;
    }


    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Рокета " + name + " запускается!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void planRocketLaunches(List<RocketLaunch> launches){
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(RocketLaunch rocket : launches){
                executorService.execute(() -> {
                    try {
                        Thread.sleep(rocket.launchTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    rocket.launch();
                });
        }
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("Ракеты не все запустились!");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Время работы программы: " + (end - start) + " мс");



    }
}

