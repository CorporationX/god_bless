package faang.school.godbless.work_standings;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MarketingResources {
    private List<String> files;

    public void addFile(String file) {
        System.out.println("Добавляем новый файл: " + file + "в потоке " + Thread.currentThread().getName());
        files.add(file);
    }

    public void readFiles() {
        System.out.println("Reading marketing files in thread " + Thread.currentThread().getName());
        for (String file : files) {
            System.out.println("Marketing file: " + file);
        }

    }
}
