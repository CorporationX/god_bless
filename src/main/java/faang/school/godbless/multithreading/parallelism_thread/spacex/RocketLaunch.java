package faang.school.godbless.multithreading.parallelism_thread.spacex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RocketLaunch {
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String launchName;
    private LocalDateTime launchTime;

    public RocketLaunch(String launchName, LocalDateTime launchTime) {
        this.launchName = launchName;
        this.launchTime = launchTime;
    }

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Launch " + launchName + " at "
                + launchTime.format(DATE_FORMAT));
    }

    public LocalDateTime getLaunchTime() {
        return launchTime;
    }
}