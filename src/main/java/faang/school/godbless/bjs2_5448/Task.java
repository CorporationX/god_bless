package faang.school.godbless.bjs2_5448;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Starting to run task: " + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Task {} was interrupted", task);
        }
    }
}
