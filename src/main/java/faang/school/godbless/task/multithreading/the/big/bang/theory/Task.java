package faang.school.godbless.task.multithreading.the.big.bang.theory;

import lombok.RequiredArgsConstructor;

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
            System.out.println("%s не смог выполнить задание".formatted(name));
        }
    }
}
