package school.faang.extremely_poor;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    public static final int MAX_WAIT_MINUTES = 1;
    private static final List<String> CHORES = Arrays.asList("помыть посуду", "подмести пол", "приготовить ужин",
            "вынести мусор", "сделать домашнее задание", "покормить рыбок");

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            executor.execute(new Thread(new Chore(chore)));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }
        log.info("Все задачи выполнены!");
    }
}