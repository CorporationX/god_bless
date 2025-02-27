package school.faang;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private final List<String> files = new ArrayList<>();

    public List<String> readFiles() {
        return files;
    }

    public void writeFile(String file) {
        files.add(file);
    }
}
