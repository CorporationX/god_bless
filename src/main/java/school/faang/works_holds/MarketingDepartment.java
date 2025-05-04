package school.faang.works_holds;

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
        List<String> loadedDesignResources;
        loadedDesignResources = designResources.getResources();
        log.info("Getting access to designResource - {}", loadedDesignResources);
        MultiThreadCounter.awaitForOtherThread();
        marketingResources.addFile("Marketing file");
    }
}

