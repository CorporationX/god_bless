package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        log.info("Design reads marketing resources.");
        List<String> marketingFiles = marketingResources.readFiles();
        log.info("Design adds the file to its resources.");
        designResources.writeFile("Design Sketch");
    }
}
