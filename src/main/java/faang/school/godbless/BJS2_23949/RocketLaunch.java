package faang.school.godbless.BJS2_23949;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class RocketLaunch {
    private final String launchName;
    private final LocalDateTime launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Launching " + launchName + " at " + launchTime);
    }
}
