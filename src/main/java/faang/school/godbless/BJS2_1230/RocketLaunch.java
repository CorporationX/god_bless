package faang.school.godbless.BJS2_1230;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String name;
    private LocalDateTime launchTime;

    public void launch() {
        System.out.println("Rocket launch '" + name + "' initiated at " + launchTime.toString() + ".");
        simulateLaunch();
        System.out.println("Rocket launch '" + name + "' successfully completed!");
    }

    private void simulateLaunch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}