package school.faang.work_stop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final List<String> nameFile = new ArrayList<>();

    public synchronized List<String> readeDesign() {
        return nameFile;
    }

    public synchronized void addFileDesign(String file) {
        nameFile.add(file);
    }
}
