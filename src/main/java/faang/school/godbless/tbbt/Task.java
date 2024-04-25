package faang.school.godbless.tbbt;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;

    private String task;

    @Override
    public void run() {
        System.out.println("Running task: " + task + " - " + name);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (Thread.currentThread().isInterrupted()) {
            System.out.println(task + " task interrupted");
        }
    }
}
