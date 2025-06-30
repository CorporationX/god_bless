package school.faang.bjs2_83068_work_deadlock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        log.info("Design department starting work.");
        try {
            analyseMarketingData();
            TimeUnit.MILLISECONDS.sleep(500);
            storeWork();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void analyseMarketingData() {
        log.info("Getting marketing resources for analysis.");
        marketingResources.readResources();
    }

    private void storeWork() {
        log.info("Storing design work.");
        designResources.addResource("new work");
    }
}
