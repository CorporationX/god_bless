package school.faang.works_holds;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class DesignDepartmentDeadLock implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> loadedMarketingResources;
        synchronized (marketingResources) {
            loadedMarketingResources = marketingResources.getResources();
            log.info("Getting access to marketingResources - {}", loadedMarketingResources);
            awaitForOtherThread();
            synchronized (designResources) {
                loadedMarketingResources.forEach(designResources::addFile);
            }
        }
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
