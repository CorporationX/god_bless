package faang.school.godbless.jobIsStack;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private final List<String> designFiles;

    public DesignResources() {
        this.designFiles = new ArrayList<>();
    }

    public void readAllFiles() {
        System.out.println("Design files:");
        System.out.println(designFiles);
    }

    public void addNewFile(String file) {
        designFiles.add(file);
    }
}
