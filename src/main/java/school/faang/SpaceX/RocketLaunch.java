package school.faang.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private long launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Ракета %s запущена!%n", name);
    }
}