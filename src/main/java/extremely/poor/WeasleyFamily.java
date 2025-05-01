package extremely.poor;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");
    private static int MAX_WAIT_SECONDS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        gracefullyShutdown(executorService);
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executor.shutdownNow();
            } else {
                log.info("Все задачи выполнены успешно.");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}
