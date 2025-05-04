package school.faang.works_holds;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> loadedMarketingResources;
        loadedMarketingResources = marketingResources.getResources();
        log.info("Getting access to marketing resources - {}", loadedMarketingResources);
        MultiThreadCounter.awaitForOtherThread();
        designResources.addFile("Design file");
    }
}
