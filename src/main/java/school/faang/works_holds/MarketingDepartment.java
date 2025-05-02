package school.faang.works_holds;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class MarketingDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> loadedDesignResources;
        loadedDesignResources = designResources.getDesignResources();
        log.info("Getting access to designResource - {}", loadedDesignResources);
        awaitForOtherThread();
        marketingResources.addFile("Marketing file");
    }

    private void awaitForOtherThread() {
        MultiThreadCounter.countDownLatch.countDown();
        while (MultiThreadCounter.countDownLatch.getCount() > 0) {
            log.debug("Waiting...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}

