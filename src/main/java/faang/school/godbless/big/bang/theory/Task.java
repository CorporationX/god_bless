package faang.school.godbless.big.bang.theory;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Task implements Runnable {
    Logger logger = LoggerFactory.getLogger(Task.class);

    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("%s has started his task \"%s\"\n", name, task);
        System.out.printf("%s is thinking\n", name);
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("%s is doing his task \"%s\"\n", name, task);
            TimeUnit.SECONDS.sleep(3);
            System.out.printf("%s did his task \"%s\"\n", name, task);
        } catch (InterruptedException exception) {
            logger.error(String.format("Thread was interrupted while %s did his task \"%s\"", name, task), exception);
            Thread.currentThread().interrupt();
        }
    }
}
