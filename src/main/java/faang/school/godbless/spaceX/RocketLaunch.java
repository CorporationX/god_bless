package faang.school.godbless.spaceX;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String nameOfLaunch;
    private LocalDateTime timeOfLaunch;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(nameOfLaunch + " starts a launch at " + timeOfLaunch);
    }
}
