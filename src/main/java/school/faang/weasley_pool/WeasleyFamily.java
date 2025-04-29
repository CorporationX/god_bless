package school.faang.weasley_pool;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@Setter
public class WeasleyFamily {
    private String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final long MAX_WAIT_MINUTES = 50;
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void executeChores() {
        for (String chore : this.chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно ", MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }
        log.info("Все задачи выполнены!");
    }
}
