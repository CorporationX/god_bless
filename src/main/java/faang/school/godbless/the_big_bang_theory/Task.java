package faang.school.godbless.the_big_bang_theory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s started his task: %s\n", this.name, this.task);
        try {
            Thread.sleep(new Random().nextInt(2000, 4500));
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("%s: %s failed: %s", this.name, this.task, Thread.currentThread().getName()));
        }
        System.out.printf("%s finished his task: %s\n", this.name, this.task);
    }
}
