package school.faang.spaceX_space_programme.BJS2_60828;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Getter
public class RocketLaunch {
    private static final long TIME_REQUIRED_FOR_STARTUP = 1000;

    private final String name;
    private final long launchTime;

    public RocketLaunch(@NonNull String name, @NonNull LocalDateTime launchTime) {
        this.name = name;
        this.launchTime = launchTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public void launch() {
        try {
            Thread.sleep(TIME_REQUIRED_FOR_STARTUP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Выполнение задачи прервано {}", e.getMessage());
        }
        log.info("Ракета {} запускается", name);
    }
}
