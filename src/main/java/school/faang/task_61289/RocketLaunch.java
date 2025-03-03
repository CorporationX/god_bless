package school.faang.task_61289;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;

import java.time.LocalDateTime;

import static school.faang.task_61289.LaunchManager.LAUNCH_PREPARE_TIME;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class RocketLaunch {
    private final String name;
    private final LocalDateTime launchTime;

    @SneakyThrows
    public void launch() {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.printf("Current time: %s %s is prepared for launching.\n", currentTime, name);
        Thread.sleep(LAUNCH_PREPARE_TIME);
        currentTime = LocalDateTime.now();
        System.out.printf("After sleep: %s\n", currentTime);
        System.out.printf("Launch time: %s Launching %s\n", launchTime, name);
    }


}
