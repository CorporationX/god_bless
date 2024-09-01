package work.waiting.department_resources;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Resources {
    private final List<String> files = new ArrayList<>();

    public synchronized String getFile() {
        return files.get(ThreadLocalRandom.current().nextInt(files.size()));
    }

    public synchronized void addFile(@NonNull String file) {
        files.add(file);
    }

    public void printAllFiles() {
        files.forEach(log::info);
    }
}
