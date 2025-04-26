package school.faang.bjs2_73277;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");
        ExecutorService executor = Executors.newFixedThreadPool(chores.size());
        long timeout = 20;

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(timeout, TimeUnit.SECONDS)) {
                log.info("The tasks were not terminated with {} seconds. Stopping the tasks now.", timeout);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted. {}.", e.getMessage());
        }
    }
}
