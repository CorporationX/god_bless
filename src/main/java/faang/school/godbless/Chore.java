package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Chore implements Runnable{
    String taskName;
    @Override
    public void run() {
        log.info("started " + taskName + " thread name " + Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("task " + taskName + " finished");
    }
}
