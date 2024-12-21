package school.faang.spring3.task_48320;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@AllArgsConstructor
@Slf4j
@Getter
public class RocketLaunch {
    private static final int DELAY = 1000;
    private String name;
    private LocalDateTime launchTime;


    public void launch() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("smth went wrong with delay");
        }
        System.out.println(name + " rocket is launched");
    }
}
