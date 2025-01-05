package derschrank.sprint04.task17.bjstwo_51287;

import java.util.ArrayList;
import java.util.List;

public class DesignResources implements Resources {
    private final List<File> files;

    public DesignResources() {
        files = new ArrayList<>();
    }

    @Override
    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public List<File> getFiles() {
        return new ArrayList<>(files);
    }
}
