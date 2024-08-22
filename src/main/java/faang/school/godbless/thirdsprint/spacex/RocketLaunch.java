package faang.school.godbless.thirdsprint.spacex;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private static final int DELAY = 1;

    private final String name;
    private final LocalDateTime launchTime;

    public void launchRocket() {
        try {
            Thread.sleep(DELAY * 1000);
            System.out.println("Rocket: " + name + " launched at " + launchTime + "\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
