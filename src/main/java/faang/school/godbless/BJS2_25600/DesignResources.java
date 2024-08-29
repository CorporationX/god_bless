package faang.school.godbless.BJS2_25600;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private final List<String> files = new ArrayList<>();

    public synchronized void addFile(String fileName) {
        System.out.println(Thread.currentThread().getName() + " добавляет файл в DesignResources: " + fileName);
        files.add(fileName);
    }

    public synchronized List<String> getFiles() {
        System.out.println(Thread.currentThread().getName() + " читает файлы из DesignResources");
        return new ArrayList<>(files);
    }
}
