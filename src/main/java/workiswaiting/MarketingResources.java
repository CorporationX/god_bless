package workiswaiting;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class MarketingResources {
    private List<String> files = new ArrayList<>();

    public MarketingResources(List<String> files) {
        this.files = new ArrayList<>(files);
    }

    public synchronized void addFiles(String file) {
        files.add(file);
    }

    public synchronized List<String> getFiles() {
        return files;
    }
}
