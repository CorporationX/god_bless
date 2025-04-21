package extremelypoor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] CHORE_LIST = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин",
            "накормить сову",
            "протереть пыль"
    };

    private static final int MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String choreName : CHORE_LIST) {
            executorService.submit(new Chore(choreName));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...%n", MAX_WAIT_MINUTES);
                executorService.shutdownNow();
            } else {
                log.info("Все домашние дела успешно завершены.");
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков было прервано.");
            executorService.shutdownNow();
        }
    }
}
