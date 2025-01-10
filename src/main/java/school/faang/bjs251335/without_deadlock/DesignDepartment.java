package school.faang.bjs251335.without_deadlock;

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
        log.info("Design gets files from marketingResources");
        List<String> marketinFiles = marketingResources.getFiles();

        log.info("Design adds files to own designResources");
        marketinFiles.forEach(designResources::addFile);
    }
}