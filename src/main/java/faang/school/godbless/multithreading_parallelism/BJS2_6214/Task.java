package faang.school.godbless.multithreading_parallelism.BJS2_6214;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Getter
@Slf4j
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Starting to do the task " + task);

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            log.error("Task {} was interrupted", task);
        }
    }
}
