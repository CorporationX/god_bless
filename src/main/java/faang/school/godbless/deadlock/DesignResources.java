package faang.school.godbless.deadlock;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private final List<String> files = new ArrayList<>();

    public void readFiles() {
        System.out.println("Reading files in design resources: ");
        files.forEach(System.out::println);
    }

    public void writeFiles(String file) {
        System.out.println("Adding file " + file + " to design resources");
        files.add(file);
    }
}
