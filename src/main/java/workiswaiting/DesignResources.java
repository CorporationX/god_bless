package workiswaiting;

import java.util.ArrayList;
import java.util.List;


public class DesignResources {
    private List<String> files = new ArrayList<>();

    public DesignResources(List<String> files) {
        this.files = new ArrayList<>(files);
    }

    public synchronized void addFiles(String file) {
        files.add(file);
    }

    public synchronized List<String> getFiles() {
        return files;
    }
}
