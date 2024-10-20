package school.faang.the_big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private final String executorName;
    private final String task;
    private static final int SLEEP_TIME = 5000;

    @Override
    public void run() {
        try {
            System.out.println(executorName + " has started working on " + task);
            Thread.sleep(SLEEP_TIME);
            System.out.println(executorName + " has finished working on " + task);
        } catch (InterruptedException e) {
            System.out.println(task + " execution by " + executorName + " had been interrupted.");
            log.error("Exception in threads connected to sleep() method ", e);
            e.printStackTrace();
        }
    }
}