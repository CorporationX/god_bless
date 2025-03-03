package school.faang.spaceX_space_programme.BJS2_60828;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LaunchPad {
    public static final int SHUTDOWN_TIMEOUT_MINUTES = 1;
    private final ExecutorService poolThread;

    public LaunchPad() {
        this.poolThread = Executors.newSingleThreadExecutor();
    }

    public void planRocketLaunches(@NonNull List<RocketLaunch> launches) {
        launches.forEach(rocketLaunch -> {
            long delay = rocketLaunch.getLaunchTime() - System.currentTimeMillis();
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                    poolThread.submit(rocketLaunch::launch);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("Выполнение задачи прервано {}", e.getMessage());
                }
            }
        });

        poolThread.shutdown();
        try {
            if (!poolThread.awaitTermination(SHUTDOWN_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.warn("Не все задачи завершились за отведённое время (1 минута). Принудительное завершение...");
                poolThread.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Процесс ожидания завершения пула был прерван. Принудительное завершение...");
            poolThread.shutdownNow();
        }
    }
}
