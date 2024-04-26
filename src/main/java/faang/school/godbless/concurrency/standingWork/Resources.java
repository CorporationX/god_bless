package faang.school.godbless.concurrency.standingWork;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Resources {
    private final String resourcesName;
    private final List<String> files = new ArrayList<>();

    public Resources(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public synchronized void lsAll() {
        log.info("The list of files in " + resourcesName + " directory: ");
        files.forEach(log::info);
    }

    public synchronized void addNewFile(@NonNull String newFile) {
        files.add(newFile);

        log.info("New file (" + newFile + ") was added to " + resourcesName + " directory.");
    }
}
