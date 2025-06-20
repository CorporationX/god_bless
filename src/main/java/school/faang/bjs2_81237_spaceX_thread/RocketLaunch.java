package school.faang.bjs2_81237_spaceX_thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Getter
@Slf4j
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime launchDateTime;

    public void launch() throws InterruptedException {
        log.info("Launching rocket: {}", name);
        TimeUnit.SECONDS.sleep(1);
        log.info("Launching {} completed", name);
    }
}
