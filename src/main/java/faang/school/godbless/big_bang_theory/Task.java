package faang.school.godbless.big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    @Override
    public void run() {
        System.out.println(name + " started the task: " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("The task was interrupted!");
            throw new RuntimeException(e);
        }

    }
}
