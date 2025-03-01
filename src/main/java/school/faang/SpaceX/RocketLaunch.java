package school.faang.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private static final long LAUNCH_DELAY = 1000;

    private String name;
    private long launchTime;

    public void launch() {
        try {
            Thread.sleep(LAUNCH_DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Ракета %s запущена!%n", name);
    }
}