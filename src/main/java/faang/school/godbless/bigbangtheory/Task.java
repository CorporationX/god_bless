package faang.school.godbless.bigbangtheory;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        log.info(name + " started executing task: " + task);
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            log.error(name + "was interrupted: " + task);
            throw new RuntimeException(e);
        }
        log.info(name + " completed task: " + task);
    }
}
