package faang.school.godbless.workBlockedTask1;

import java.util.List;

public class MarketingResources {
    private final List<String> files;

    public MarketingResources(List<String> files) {
        this.files = files;
    }

    public synchronized List<String> readFiles() {
        return files;
    }

    public synchronized void addFile(String fileName) {
        files.add(fileName);
    }
}
