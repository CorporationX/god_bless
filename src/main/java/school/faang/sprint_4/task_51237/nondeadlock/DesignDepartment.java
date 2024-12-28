package school.faang.sprint_4.task_51237.nondeadlock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> fileNames = marketingResources.getFileNames();
        log.info("Marketing resources loaded by design department");

        for (String fileName : fileNames) {
            designResources.addFileName(fileName);
            log.info("Design file added: {}", fileName);
        }
    }
}
