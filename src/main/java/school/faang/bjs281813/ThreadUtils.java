package school.faang.bjs281813;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadUtils {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Поток '{}' был прерван", Thread.currentThread().getName());
        }
    }
}