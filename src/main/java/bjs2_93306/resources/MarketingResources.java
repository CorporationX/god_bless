package bjs2_93306.resources;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private final List<String> files = new ArrayList<>();

    public synchronized void addFile(String file) {
        files.add(file);
    }

    public synchronized List<String> getFiles() {
        return files;
    }
}