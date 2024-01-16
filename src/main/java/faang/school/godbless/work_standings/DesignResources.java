package faang.school.godbless.work_standings;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignResources {
    private List<String> files;

    public void addFile(String file) {
        System.out.println("Добавляем новый файл: " + file + "в потоке " + Thread.currentThread().getName());
        files.add(file);
    }

    public void readFiles() {
        System.out.println("Reading design files in thread " + Thread.currentThread().getName());
        for (String file : files) {
            System.out.println("Design file: " + file);
        }
    }
}
