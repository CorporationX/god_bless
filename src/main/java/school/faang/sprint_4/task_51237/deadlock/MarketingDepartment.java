package school.faang.sprint_4.task_51237.deadlock;

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
        synchronized (designResources) {
            List<String> fileNames = designResources.getFileNames();
            log.info("Design resources loaded by marketing department");

            synchronized (marketingResources) {
                for (String fileName : fileNames) {
                    marketingResources.addFileName(fileName);
                    log.info("Marketing file added: {}", fileName);
                }
            }
        }
    }
}
