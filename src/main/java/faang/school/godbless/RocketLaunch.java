package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private long launchTime;

    public void launch() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Launching rocket " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
