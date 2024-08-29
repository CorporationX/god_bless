package faang.school.godbless.workisstopping;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MarketingResources {
    private final List<String> files = new ArrayList<>();

    public synchronized void addFile(String fileName) {
        log.info("Marketing Department is adding file: {}", fileName);
        files.add(fileName);
    }

    public synchronized void getFiles() {
        System.out.println("Marketing Department is browsing the files.");
    }
}