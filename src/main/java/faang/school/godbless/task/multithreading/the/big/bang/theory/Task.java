package faang.school.godbless.task.multithreading.the.big.bang.theory;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class Task implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(Task.class);
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.println("%s начал выполнять задание: %s".formatted(name, task));
            Thread.sleep(3000);
            System.out.println("%s выполнил задание".formatted(name));
        } catch (InterruptedException exception) {
            logger.error("Interrupted exception: {}", exception.getMessage());
        }
    }
}
