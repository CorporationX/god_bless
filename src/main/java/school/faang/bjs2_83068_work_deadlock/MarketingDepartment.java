package school.faang.bjs2_83068_work_deadlock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        log.info("Marketing department starting work.");
        try {
            analyseDesigns();
            TimeUnit.MILLISECONDS.sleep(500);
            storeWork();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void analyseDesigns() {
        log.info("Getting design resources for analysis.");
        designResources.readResources();
    }

    private void storeWork() {
        log.info("Storing marketing work.");
        marketingResources.addResource("new work");
    }
}
