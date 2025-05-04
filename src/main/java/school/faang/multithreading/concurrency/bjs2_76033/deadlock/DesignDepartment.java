package school.faang.multithreading.concurrency.bjs2_76033.deadlock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (marketingResources) {
            log.info("DesignDepartment reads marketing resources");
            List<String> marketingFiles = marketingResources.getFiles();

            synchronized (designResources) {
                log.info("DesignDepartment is going to add file in own resources");
                designResources.addFile("DesignDepartmentAnalysis");
            }
        }
    }
}
