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
        marketingResources.addFile("Market Analysis");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.error("Marketing Department has been interrupted: ", e);
            Thread.currentThread().interrupt();
        }
        designResources.getFiles();
        marketingResources.addFile("Design Feedback");
    }
}