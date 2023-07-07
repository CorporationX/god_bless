package faang.school.godbless.workBlockedTask1;

import java.util.List;

public class DesignResources {
    private final List<String> files;

    public DesignResources(List<String> files) {
        this.files = files;
    }

    public synchronized List<String> readFiles() {
        return files;
    }

    public synchronized void addFile(String fileName) {
        files.add(fileName);
    }
}
