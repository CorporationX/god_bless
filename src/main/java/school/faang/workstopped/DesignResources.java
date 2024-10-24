package school.faang.workstopped;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private final List<String> files = new ArrayList<>();

    public synchronized List<String> readFiles() {
        System.out.println("Reading files from Design Resources");
        return new ArrayList<>(files);
    }

    public synchronized void addFile(String fileName) {
        System.out.println("Adding file to Design Resources: " + fileName);
        files.add(fileName);
    }
}