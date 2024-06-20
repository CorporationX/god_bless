package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(getTask());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException("The task was interrupted.");
        }
    }
}
