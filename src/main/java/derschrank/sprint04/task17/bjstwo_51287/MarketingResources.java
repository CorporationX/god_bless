package derschrank.sprint04.task17.bjstwo_51287;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources implements Resources {
    private final List<File> files;

    public MarketingResources() {
        files = new ArrayList<>();
    }

    @Override
    public synchronized void addFile(File file) {
        files.add(file);
    }

    @Override
    public synchronized List<File> getFiles() {
        return new ArrayList<>(files);
    }
}
