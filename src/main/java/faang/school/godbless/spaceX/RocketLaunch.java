package faang.school.godbless.spaceX;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RocketLaunch {
    private String name;
    private LocalDateTime startTime;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Rocket launch was interrupted");
        }
        System.out.println("Launch of " + name + " completed successfully");
    }
}
