package school.faang;

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
        log.info("Marketing reads design resources.");
        List<String> designFiles = designResources.readFiles();
        log.info("Marketing adds the file to its resources.");
        marketingResources.writeFile("Marketing analysis");
    }
}
