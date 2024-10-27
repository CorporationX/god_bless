package school.faangSprint4.t15;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private static final int SLEEP_TIME = 100;
    private final List<String> files = new ArrayList<>();

    public synchronized void readFiles() {
        System.out.println(Thread.currentThread().getName() + " читает файлы маркетинга: " + files);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeFile(String filename) {
        files.add(filename);
        System.out.println(Thread.currentThread().getName() + " записывает файл маркетинга: " + filename);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}