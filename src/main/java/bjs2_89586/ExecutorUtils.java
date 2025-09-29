package bjs2_89586;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class ExecutorUtils {

    private static final Logger log = LoggerFactory.getLogger(ExecutorUtils.class);

    private static final long AWAIT_TERMINATION_TIMEOUT = 1L;
    private static final TimeUnit AWAIT_TERMINATION_UNIT = TimeUnit.MINUTES;

    private ExecutorUtils() {}

    public static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIMEOUT, AWAIT_TERMINATION_UNIT)) {
                log.warn("Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executor.shutdownNow();
            } else {
                log.info("Все задачи выполнены успешно.");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван.", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt(); // восстанавливаем статус прерывания
        }
    }
}