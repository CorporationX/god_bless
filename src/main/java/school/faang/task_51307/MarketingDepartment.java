package school.faang.task_51307;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        log.info("The marketing department reads the design files...");
        log.info("Design file names: {}", designResources.getFileNames());
        log.info("The marketing department adds the file");
        marketingResources.addFileName("Some important file");
    }
}
