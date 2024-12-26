package school.faang.sprint_4.task_51237.deadlock;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private final List<String> fileNames = new ArrayList<>();

    public void addFileName(String fileName) {
        fileNames.add(fileName);
    }

    public List<String> getFileNames() {
        return List.copyOf(fileNames);
    }
}
