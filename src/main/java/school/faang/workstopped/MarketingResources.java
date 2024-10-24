package school.faang.workstopped;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private final List<String> files = new ArrayList<>();

    public synchronized List<String> readFiles() {
        System.out.println("Reading files from Marketing Resources");
        return new ArrayList<>(files);
    }

    public synchronized void addFile(String fileName) {
        System.out.println("Adding file to Marketing Resources: " + fileName);
        files.add(fileName);
    }
}