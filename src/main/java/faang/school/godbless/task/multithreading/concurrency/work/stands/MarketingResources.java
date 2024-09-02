package faang.school.godbless.task.multithreading.concurrency.work.stands;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class MarketingResources {
    private final List<String> files = new CopyOnWriteArrayList<>();

    public void showAllFiles() {
        log.info("Reading Marketing resources files:");
        sleep();
        var fileNames = new StringBuilder("\nMarketing resources files:\n");
        files.forEach(file -> fileNames.append(file).append("\n"));
        log.info("{}", fileNames);
    }

    public void addFile(String file) {
        log.info("Writing new file: {} into Marketing resources", file);
        sleep();
        files.add(file);
        log.info("Writing into Marketing resources done");
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
