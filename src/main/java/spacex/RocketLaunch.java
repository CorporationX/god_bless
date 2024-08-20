package spacex;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private final String missionName;
    private LocalDateTime launchTime;

    public void launch() {
        try {
            System.out.printf("We have liftoff of Falcon 9 on the %s mission at %s%n", missionName, launchTime);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Launch failed!");
            throw new RuntimeException(e);
        }
    }
}
