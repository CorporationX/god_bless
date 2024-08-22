package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private String executorName;
    private String task;

    @Override
    public void run() {
        System.out.println(executorName + " Running task: " + task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(executorName + " Task interrupted");
            return;
        }
        System.out.println(executorName + " Finished task");
    }
}
