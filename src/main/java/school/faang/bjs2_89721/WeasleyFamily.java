package school.faang.bjs2_89721;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    public static void main(String[] args) {

        String[] chores = new String[]{"Wash the floor", "Wash the dishes", "Dust the furniture", "Wash the windows"};

        ExecutorService executors = Executors.newCachedThreadPool();

        for (String c : chores) {
            Chore chore = new Chore(c);
            executors.submit(chore);
        }
        executors.shutdown();
        try {
            if (!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Some chose were not finish in time ...");
                executors.shutdownNow();
            } else {
                log.info("All chores completed successfully");
            }
        } catch (InterruptedException e) {
            log.error(Thread.currentThread().getName() + " got interrupted while waiting");
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
