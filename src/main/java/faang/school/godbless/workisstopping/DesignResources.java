package faang.school.godbless.workisstopping;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DesignResources {
    private final List<String> files;

    public DesignResources() {
        this.files = new ArrayList<>();
    }

    public synchronized void addFile(String fileName) {
        log.info("Design Department is adding file: {}", fileName);
    }

    public synchronized void getFiles() {
        log.info("Design Department is browsing the files.");
    }
}