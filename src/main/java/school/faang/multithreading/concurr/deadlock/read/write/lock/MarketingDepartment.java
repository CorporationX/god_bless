package school.faang.multithreading.concurr.deadlock.read.write.lock;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MarketingDepartment implements Runnable {
    private final static int TIME_TO_SLEEP = 1000;

    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @SneakyThrows
    @Override
    public void run() {
        log.info("Департамент маркетинга читает файлы Департамента дизайна");
        List<String> filesNames = designResources.getFilesNames();
        Thread.sleep(TIME_TO_SLEEP);
        log.info("Департамент маркетинга копирует файлы Департамента дизайна");
        filesNames.forEach(marketingResources::addFileName);
    }
}
