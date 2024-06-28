package faang.school.godbless.work_stands;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class DesignResources {
    private final List<String> designFiles = new ArrayList<>();

    public synchronized List<String> readFiles() {
        return designFiles;
    }

    public synchronized void addFile(String file) {
        designFiles.add(file);
    }
}
