package school.faang.sprint_3.they_were_very_nice_but_extremely_poor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {

        WeasleyFamily weasleyFamily = new WeasleyFamily(new String[] {
                "Make the bed", "Wash the dishes", "Clean the kitchen", "Take out the trash"
        });

        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (String chore : weasleyFamily.getChores()) {
            threadPool.submit(new Chore(chore));
        }

        threadPool.shutdown();

        try {
            if (!threadPool.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Tasks executes more then 10 seconds");
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
                threadPool.shutdownNow();
        }
    }
}