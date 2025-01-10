package school.faang.bjs251335.with_deadlock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (designResources) {
            log.info("Marketing gets files from designResources");
            List<String> designFiles = designResources.getFiles();

            synchronized (marketingResources) {
                log.info("Marketing adds files to own marketingResources");
                designFiles.forEach(marketingResources::addFile);
            }
        }
    }
}