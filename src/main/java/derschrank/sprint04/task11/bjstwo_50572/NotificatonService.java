package derschrank.sprint04.task11.bjstwo_50572;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificatonService {
    public static void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("Was interrupted: " + e);
        }
    }
}
