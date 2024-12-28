package school.faang.sprint_4.task_51237.nondeadlock;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MarketingResources {
    private final List<String> fileNames = new CopyOnWriteArrayList<>();

    public void addFileName(String fileName) {
        fileNames.add(fileName);
    }

    public List<String> getFileNames() {
        return List.copyOf(fileNames);
    }
}
