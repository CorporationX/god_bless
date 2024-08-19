package faang.school.godbless.task.multithreading.the.big.bang.theory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.println("%s начал выполнять задание: %s".formatted(name, task));
            Thread.sleep(3000);
            System.out.println("%s выполнил задание".formatted(name));
        } catch (InterruptedException exception) {
            log.error("Interrupted exception: {}", exception.getMessage());
        }
    }
}
