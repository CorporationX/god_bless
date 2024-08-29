package faang.school.godbless.BJS2_25600;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private final List<String> files = new ArrayList<>();

    public synchronized void addFile(String fileName) {
        System.out.println(Thread.currentThread().getName() + " добавляет файл в MarketingResources: " + fileName);
        files.add(fileName);
    }

    public synchronized List<String> getFiles() {
        System.out.println(Thread.currentThread().getName() + " читает файлы из MarketingResources");
        return new ArrayList<>(files);
    }
}
