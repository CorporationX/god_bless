package faang.school.godbless.skynet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Robot {
    private final String target;

    public void attack() {
        synchronized(target) {
            log.info("Robot attacking target: " + target);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Robot finished attacking target: " + target);
        }
    }
}
