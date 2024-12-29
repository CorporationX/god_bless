package school.faang.sprint4.task_51277;

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
        log.info(Thread.currentThread().getName() + " is started");
        List<String> marketing = marketingResources.getFiles();
        designResources.addNewFile("Design template");
    }
}
