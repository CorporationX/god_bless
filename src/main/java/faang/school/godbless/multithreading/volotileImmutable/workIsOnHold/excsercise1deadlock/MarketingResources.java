package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.excsercise1deadlock;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private List<String> fileNames = new ArrayList<>();


    public synchronized List<String> readAllFiles() {
            return fileNames;
    }

    public synchronized void addFile(String file) {
            fileNames.add(file);
    }
}
