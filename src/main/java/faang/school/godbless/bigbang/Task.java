package faang.school.godbless.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    String name;
    String task;

    @Override
    public void run() {

        System.out.println(task + "was started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Task aborted");
            throw new RuntimeException(e);
        }
    }
}
