package faang.school.godbless.work_stands;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class MarketingResources {
    private final List<String> marketingFiles = new ArrayList<>();

    public synchronized List<String> readFiles() {
        return marketingFiles;
    }

    public synchronized void addFile(String file) {
        marketingFiles.add(file);
    }
}
