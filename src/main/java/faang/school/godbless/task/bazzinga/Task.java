package faang.school.godbless.task.bazzinga;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + ": " + task + "...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(task + " was interrupted");
        }
    }
}
