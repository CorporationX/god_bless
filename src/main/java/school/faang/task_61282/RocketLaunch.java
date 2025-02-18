package school.faang.task_61282;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RocketLaunch {
    private final String name;
    private final LocalDateTime launchTime;

    public RocketLaunch(String name, LocalDateTime launchTime) {
        this.name = name;
        this.launchTime = launchTime;
    }

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println(name + " was launched");
        } catch (InterruptedException e) {
            System.out.println("Launch was interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
