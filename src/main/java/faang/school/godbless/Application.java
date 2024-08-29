package faang.school.godbless;

import faang.school.godbless.Rocket.RocketLaunch;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    public long planRocketLaunches(List<RocketLaunch> rocketLaunches){
        long startTime = System.currentTimeMillis();

        ExecutorService executors = Executors.newSingleThreadExecutor();

        try {
            for(RocketLaunch rocketLaunch : rocketLaunches){
                long delay = rocketLaunch.getLaunchTime() - System.currentTimeMillis();

                executors.submit(() -> {
                    try {
                        if(delay > 0){
                            Thread.sleep(delay);
                        }
                        rocketLaunch.launch();
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }finally {
            executors.shutdown();
            try{
                if(!executors.awaitTermination(rocketLaunches.size() * 2, TimeUnit.SECONDS)) {
                    executors.shutdownNow();
                }
            }catch(InterruptedException e){
                executors.shutdownNow();
            }
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        List<RocketLaunch> rocketLaunches = List.of(
                new RocketLaunch("Falcon 1", System.currentTimeMillis() + 1000),
                new RocketLaunch("Falcon 2", System.currentTimeMillis() + 3000),
                new RocketLaunch("Falcon Heavy", System.currentTimeMillis() + 5000)
        );

        Application app = new Application();

        app.planRocketLaunches(rocketLaunches);
    }
}