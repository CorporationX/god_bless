package faang.school.godbless.bbt;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Task implements Runnable {

    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.printf("%s is starting task: %s%n", name, task);
            Thread.sleep(10000);
            System.out.printf("%s finished task: %s%n", name, task);
        } catch (InterruptedException e) {
            System.out.printf("'%s' task by %s was interrupted!%n", task, name);
        }
    }
}
