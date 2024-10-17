package school.faang.spacex;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Getter
@Slf4j
public class RocketLaunch {
    private final String name;
    private final long launchTime;

    public RocketLaunch(String name, LocalDateTime launchTime) {
        this.name = name;
        ZonedDateTime zonedDateTime = launchTime.atZone(ZoneId.systemDefault());
        this.launchTime = zonedDateTime.toInstant().toEpochMilli();
    }

    public void launch() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
        System.out.println("Ракета " + name + " запускается!");
    }
}
