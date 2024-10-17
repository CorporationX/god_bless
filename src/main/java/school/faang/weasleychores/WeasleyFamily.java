package school.faang.weasleychores;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash the dishes", "sweep the floor", "cook dinner", "do the laundry", "walk the rat"};
        ExecutorService choresService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            Chore someChore = new Chore(chore);
            choresService.submit(someChore);
        }

        choresService.shutdown();
        try {
            if (!choresService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Tasks not completed in 5 minutes, forced stop");
                choresService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Caught exception: {}", args, e);
            choresService.shutdownNow();
        }
    }

}
