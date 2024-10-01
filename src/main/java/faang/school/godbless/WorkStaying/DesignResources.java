package faang.school.godbless.WorkStaying;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private List<String> folder = new ArrayList<>();

    public synchronized void addFile(String file) {
        folder.add(file);
        try {
            System.out.println("дизайн работает над файлом: " + file);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAllFiles() {
        for (String file : folder) {
            System.out.println(file);
        }
    }
}
