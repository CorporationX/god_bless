package school.faang.BJS2_36396_NormalGamePigs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Getter
@AllArgsConstructor
public abstract class PigThread extends Thread {
    private static final int MILLISECONDS_IN_SECOND = 1_000;
    private static final int BUILDING_DURATION_SEC_MIN = 3;
    private static final int BUILDING_DURATION_SEC_MAX = 7;

    private String pigName;
    private String material;

    @Override
    public void run() {
        log.info("{} started building a house out of {}", getPigName(), getMaterial());
        int buildingDuration =
                ThreadLocalRandom.current().nextInt(BUILDING_DURATION_SEC_MIN, BUILDING_DURATION_SEC_MAX) * MILLISECONDS_IN_SECOND;
        try {
            Thread.sleep(buildingDuration);
        } catch (InterruptedException e) {
            log.error(
                    "Thread {} was interrupted while building a house for pig {}. Exception: {}",
                    Thread.currentThread().getName(), pigName, e.getMessage(),
                    e
            );
        }
        log.info("{} finished building a house out of {}", getPigName(), getMaterial());
    }
}
