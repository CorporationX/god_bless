package school.faang.extremelypoor;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        WeasleyFamily weasleyFamily = new WeasleyFamily();
        for (String task : weasleyFamily.getChores()) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        log.info("Initiating shutdown");
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Forcing shutdown!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Shutdown interrupted, forcing stop", e);
            executor.shutdownNow();
        }
    }
}
