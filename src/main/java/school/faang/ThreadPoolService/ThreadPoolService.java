package school.faang.ThreadPoolService;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolService {

    public static void shutdownPool(ExecutorService service, long awaitTerminationTime, TimeUnit timeUnit) {
        service.shutdown();
        try {
            if (!service.awaitTermination(awaitTerminationTime, timeUnit)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been terminated", e);
        }
    }
}
