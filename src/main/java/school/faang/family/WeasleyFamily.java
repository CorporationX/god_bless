package school.faang.family;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    Logger log = (Logger) LoggerFactory.getLogger(WeasleyFamily.class);
    private final int maxWaitMinutes = 5;
    List<String> familyChores = new ArrayList<>(List.of("помыть посуду", "подмести пол"));

    ExecutorService executor = Executors.newCachedThreadPool();

    public void addChore(String task) {
        familyChores.add(task);
    }

    public void doChores() {
        for (String task : familyChores) {
            executor.submit(new Chore(task));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(maxWaitMinutes, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", maxWaitMinutes);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
