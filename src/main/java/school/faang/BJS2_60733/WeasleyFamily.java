package school.faang.BJS2_60733;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    private static final String[] chores = new String[]{ "помыть посуду", "подмести пол", "приготовить ужин"};
    private static final int WAIT_TIME_IN_SECONDS = 60;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            for (String task : chores) {
                executor.submit(new Chore(task));
            }
        } catch (Exception e) {
            log.info("Ошибка при добавлении задач в пул потоков");
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(WAIT_TIME_IN_SECONDS, TimeUnit.SECONDS)) {
                    log.warn("Не все задачи завершились вовремя. Принудительное завершение...");
                    executor.shutdownNow();
                }
            } catch (InterruptedException ex) {
                log.error("Ожидание завершения потоков было прервано.", ex);
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
