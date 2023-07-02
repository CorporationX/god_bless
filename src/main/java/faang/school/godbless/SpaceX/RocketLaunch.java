package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RocketLaunch{
    private String launchName;
    private LocalDateTime launchTime;

    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(launchName + " launched at " + launchTime);
    }
}
