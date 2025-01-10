package school.faang.bjs251335.with_deadlock;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
public class DesignResources {

    private final List<String> files = new ArrayList<>();

    public synchronized void addFile(String fileName) {
        files.add(fileName);
    }

    public synchronized List<String> getFiles() {
        return files;
    }
}