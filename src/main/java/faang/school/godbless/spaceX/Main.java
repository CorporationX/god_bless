package faang.school.godbless.spaceX;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long timeOfStart = new Date().getTime();
        RocketLaunch rocketLaunch1 = new RocketLaunch("Falcon", timeOfStart + 1000);
        RocketLaunch rocketLaunch2 = new RocketLaunch("Dragon", timeOfStart + 2000);
        RocketLaunch rocketLaunch3 = new RocketLaunch("Souz", timeOfStart + 3000);
        RocketLaunch rocketLaunch4 = new RocketLaunch("Upiter", timeOfStart + 4000);
        List<RocketLaunch> launches = new ArrayList<>();
        launches.add(rocketLaunch1);
        launches.add(rocketLaunch2);
        launches.add(rocketLaunch3);
        launches.add(rocketLaunch4);

        planRocketLaunches(launches);
    }
     private static void planRocketLaunches(List<RocketLaunch> launches){
         ExecutorService executorService = Executors.newSingleThreadExecutor();
         long timeOfStart = new Date().getTime();
         for(var launch : launches){
             executorService.submit(launch);
         }
         executorService.shutdown();
         try {
             if (executorService.awaitTermination(7, TimeUnit.SECONDS)) {
                 long timeOfEnd = new Date().getTime();
                 System.out.println("Время выполнения программы : " + (timeOfEnd - timeOfStart) + " миллисекунды"
                 + ". \nПриблизительно : " + (timeOfEnd - timeOfStart)/1000 + " секунды");
             }
         } catch (InterruptedException e){
             throw new RuntimeException();
         }
     }
}
