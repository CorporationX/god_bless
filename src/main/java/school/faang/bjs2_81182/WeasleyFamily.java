package school.faang.bjs2_81182;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) {
        String[] chores = {"готовить", "уборка", "вода мыть посуда", "стиралка"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }
    }
}