package school.faang.household;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int MAX_WAIT_MINUTES = 1;
    private static final String[] CHORES = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин",
            "протереть пыль",
            "постирать",
            "полить цветы",
            "погладить"
    };

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            for (String chore : CHORES) {
                executor.execute(new Chore(chore));
            }
        } finally {
            log.info("Все задачи добавлены в пул");
            executor.shutdown();
            try {
                if (executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                    log.info("Все задачи успешно завершены");
                } else {
                    log.warn("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                log.error("Ожидание завершения потоков прервано.");
                executor.shutdownNow();
            }
        }
    }
}
