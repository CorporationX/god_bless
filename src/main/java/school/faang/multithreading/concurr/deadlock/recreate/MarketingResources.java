package school.faang.multithreading.concurr.deadlock.recreate;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private final List<String> fileNames = new ArrayList<>();

    public synchronized List<String> getFilesNames() {
        return fileNames;
    }

    public synchronized void addFileName(String name) {
        fileNames.add(name);
    }
}
