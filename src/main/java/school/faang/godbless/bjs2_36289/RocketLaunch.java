package school.faang.godbless.bjs2_36289;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class RocketLaunch {
    private static final int DELAY = 1000;

    private String name;
    @Getter
    private long launchTimeMillis;

    public void launch() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted when launching");
        }
        log.info("Launching rocket {}", name);
    }
}
