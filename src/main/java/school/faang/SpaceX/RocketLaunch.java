package school.faang.SpaceX;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
public class RocketLaunch {

    private String name;
    private long launchTime;

    public RocketLaunch(String name, LocalDateTime launchTime) {
        this.name = name;
        ZonedDateTime zonedDateTime = launchTime.atZone(ZoneId.systemDefault());
        this.launchTime = zonedDateTime.toInstant().toEpochMilli();
    }

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread interrupted");
        }
        System.out.println(name + " launched at " + new Date(launchTime));
    }
}
