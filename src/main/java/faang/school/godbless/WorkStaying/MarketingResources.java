package faang.school.godbless.WorkStaying;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private List<String> folder = new ArrayList<>();

    public void addFile(String file) {
        folder.add(file);
        try {
            System.out.println("маркетинг работает над файлом: " + file);
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
