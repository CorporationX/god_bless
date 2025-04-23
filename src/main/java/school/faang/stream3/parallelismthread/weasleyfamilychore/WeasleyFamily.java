package school.faang.stream3.parallelismthread.weasleyfamilychore;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final List<String> weasleyChores = Arrays.asList("помыть посуду", "подмести пол", "приготовить ужин");

    public void startChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : weasleyChores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(6000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("executor " + " was interrapted forcedly\n" + e.getMessage());
            executor.shutdownNow();
        }
    }
}
