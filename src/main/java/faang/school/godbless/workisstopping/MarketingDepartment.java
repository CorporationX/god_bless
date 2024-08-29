package faang.school.godbless.workisstopping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class MarketingDepartment extends Thread {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (marketingResources) {
            log.info("Marketing Department has begun working with marketing resources.");
            marketingResources.addFile("Market Analysis");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error("Marketing Department has been interrupted: ", e);
                Thread.currentThread().interrupt();
            }
            log.info("Marketing Department is trying to access design resources.");
            synchronized (designResources) {
                designResources.getFiles();
                marketingResources.addFile("Design Feedback");
            }
        }
    }
}