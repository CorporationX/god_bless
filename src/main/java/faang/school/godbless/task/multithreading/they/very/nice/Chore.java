package faang.school.godbless.task.multithreading.they.very.nice;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(Chore.class);
    private final String chore;

    @Override
    public void run() {
        logger.info("Задача '%s' выполняется в потоке: %s"
                .formatted(chore, Thread.currentThread().getName()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            logger.error("Interrupted exception: {}", exception.getMessage());
        }
    }
}
