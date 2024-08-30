package faang.school.godbless.task.multithreading.concurrency.work.stands;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class DesignResources {
    private final List<String> files = new CopyOnWriteArrayList<>();

    public void showAllFiles() {
        log.info("Reading Design resources files:");
        sleep();
        var fileNames = new StringBuilder("\nDesign resources files:\n");
        files.forEach(file -> fileNames.append(file).append("\n"));
        log.info("{}", fileNames);
    }

    public void addFile(String file) {
        log.info("Writing new file: {} into Design resources", file);
        sleep();
        files.add(file);
        log.info("Writing into Design resources done");
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
