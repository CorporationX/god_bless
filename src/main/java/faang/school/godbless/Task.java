package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Task implements Runnable{
    String name;
    String task;
    @Override
    public void run() {
        log.info(name + " started task " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.info("interupted " + name + " " + task);
//            throw new RuntimeException(e);
        }
        log.info("finished " + name + " " + task);
    }
}
