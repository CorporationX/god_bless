package bjs2_62545;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class ForeverOperationStopper implements Runnable {
    private final int waitingTerminationTimeoutMs;
    private final ScheduledExecutorService scheduledExecutor;
    private final String finishMessage;

    @Override
    public void run() {
        if (scheduledExecutor.isShutdown()) {
            return;
        }

        scheduledExecutor.shutdown();

        try {
            if (!scheduledExecutor.awaitTermination(waitingTerminationTimeoutMs, TimeUnit.MILLISECONDS)) {
                scheduledExecutor.shutdownNow();
            }
        } catch (Exception e) {
            log.error("Ошибка при ожидании остановки потока: {}", e.getMessage(), e);
        }
        
        log.info(finishMessage);
    }
}
