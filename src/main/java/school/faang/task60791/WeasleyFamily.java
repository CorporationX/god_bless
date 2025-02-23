package school.faang.task60791;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String SUCCESS_MESSAGE = "Все задачи завершены";
    private static final String ERROR_MESSAGE = "Время ожидания истекло, не все задачи завершены";
    private static final String INTERRUPTED_MESSAGE = "Ожидание прервано";
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        List<Chore> chores =
                List.of(new Chore("Помыть посуду"), new Chore("Подмести пол"), new Chore("Приготовить ужин"));

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executor.submit(chore);
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info(SUCCESS_MESSAGE);
            } else {
                log.warn(ERROR_MESSAGE);
            }
        } catch (InterruptedException e) {
            log.error(INTERRUPTED_MESSAGE);
        }
    }
}
