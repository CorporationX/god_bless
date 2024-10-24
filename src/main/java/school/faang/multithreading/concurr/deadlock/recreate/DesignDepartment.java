package school.faang.multithreading.concurr.deadlock.recreate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DesignDepartment implements Runnable {
    private final static int TIME_TO_SLEEP = 1000;

    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (marketingResources) {
            log.info("Департамент дизайна читает файлы Департамента маркетинга");
            List<String> filesNames = marketingResources.getFilesNames();
            Thread.sleep(TIME_TO_SLEEP);
            log.info("Департамент дизайна ждет когда откроют доступ до designResources...");
            synchronized (designResources) {
                log.info("Департамент дизайна копирует файлы Департамента маркетинга");
                filesNames.forEach(designResources::addFileName);
            }
        }
    }
}
