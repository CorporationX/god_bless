package school.faang.bjs2_81156;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final List<Chore> chores;

    public WeasleyFamily() {
        this.chores = new ArrayList<>();
    }

    public WeasleyFamily(List<Chore> chores) {
        this.chores = chores;
    }


    public void doHomeWork() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.submit(chore);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.warn("Не все задачи были завершены");
        }
    }

}
