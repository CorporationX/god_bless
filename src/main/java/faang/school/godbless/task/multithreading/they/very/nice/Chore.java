package faang.school.godbless.task.multithreading.they.very.nice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        log.info("Задача '%s' выполняется в потоке: %s"
                .formatted(chore, Thread.currentThread().getName()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            log.error("Interrupted exception: {}", exception.getMessage());
        }
    }
}
