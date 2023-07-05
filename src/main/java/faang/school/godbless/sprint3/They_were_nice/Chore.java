package faang.school.godbless.sprint3.They_were_nice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private String task;

    @Override
    public void run() {
        System.out.println(String.format("Task: %s in %s started", task, Thread.currentThread().getName()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("Task: %s in %s finished", task, Thread.currentThread().getName()));

    }
}
