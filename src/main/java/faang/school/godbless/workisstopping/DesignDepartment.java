package faang.school.godbless.workisstopping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class DesignDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        designResources.addFile("Product Design");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.error("Design Department has been interrupted: ", e);
            Thread.currentThread().interrupt();
        }
        marketingResources.getFiles();
        designResources.addFile("Marketing Input");
    }
}