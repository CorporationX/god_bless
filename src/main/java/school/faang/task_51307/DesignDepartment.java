package school.faang.task_51307;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        log.info("The design department reads the marketing files...");
        log.info("Marketing file names: {}", marketingResources.getFileNames());
        log.info("The design department adds the file");
        designResources.addFileName("Some important file");
    }
}
