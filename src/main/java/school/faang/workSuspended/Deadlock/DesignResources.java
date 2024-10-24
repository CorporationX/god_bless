package school.faang.workSuspended.Deadlock;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignResources {
    private final List<String> designFiles;

    public synchronized void addFile(String file) {
        designFiles.add(file);
    }

    public synchronized List<String> getDesignFiles() {
        return designFiles;
    }
}
