package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private final LocalDateTime launchDateTime;

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Rocket " + name + " launched at " + LocalDateTime.now());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
