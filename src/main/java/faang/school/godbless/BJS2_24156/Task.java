package faang.school.godbless.BJS2_24156;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Task implements Runnable {

    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.println(name + " started: " + task);

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            System.out.println("Task " + name + " interrupted");
        }
    }
}
