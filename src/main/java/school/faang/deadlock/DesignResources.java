package school.faang.deadlock;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Getter
public class DesignResources {
    private final List<String> files = new CopyOnWriteArrayList<>();

    public List<String> readFile() {
        System.out.println("Список файлов для проектирования:");
        files.forEach(file -> System.out.println("-" + file));
        return this.files;
    }

    public void writeFile(String file) {
        log.info("Запись файлов для проектирования");
        files.add(file);
    }
}
