package school.faang.multithreading.concurrency.bjs2_76033.deadlock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (designResources) {
            log.info("MarketingDepartment reads design resources");
            List<String> designFiles = designResources.getFiles();

            synchronized (marketingResources) {
                log.info("MarketingDepartment is going to add file in own resources");
                marketingResources.addFile("MarketingDepartmentAnalysis");
            }
        }
    }
}
