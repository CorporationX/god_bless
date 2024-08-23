package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.printf("%s has been started by %s\n", task, name);
            Thread.sleep(3000L);
            System.out.printf("%s has been finished by %s\n", task, name);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted while doing %s\n", name, task);
            Thread.currentThread().interrupt();
        }
    }
}
