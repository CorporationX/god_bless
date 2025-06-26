package school.faang.bjs2_83059.resources;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private final List<String> files = new ArrayList<>();

    public synchronized void readFiles(String reader) {
        System.out.println(reader + " reading design files: " + files);
    }

    public synchronized void writeFile(String file) {
        files.add(file);
        System.out.println("Design file added: " + file);
    }
}
