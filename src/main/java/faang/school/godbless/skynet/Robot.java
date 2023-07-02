package faang.school.godbless.skynet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Robot {
    private String target;

    public synchronized void attack() {
        log.info("Robot attacking target: " + target);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Robot finished attacking target: " + target);
    }
}
