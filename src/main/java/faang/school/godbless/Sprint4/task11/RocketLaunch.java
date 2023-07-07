package faang.school.godbless.Sprint4.task11;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime launchTime;

    public void launch() {
        long delay = LocalDateTime.now().until(launchTime, ChronoUnit.MILLIS);
        if (delay > 0) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Rocket " + name + " launched");
    }
}
