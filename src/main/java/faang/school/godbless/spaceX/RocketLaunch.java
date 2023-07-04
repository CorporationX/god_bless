package faang.school.godbless.spaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
@Setter
public class RocketLaunch {
    private String name;
    private LocalDateTime launchTime;

    public void launch() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Launch: " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
