package faang.school.godbless.deadlock;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private final List<String> files = new ArrayList<>();

    public void readFiles() {
        System.out.println("Reading files in marketing resources: ");
        files.forEach(System.out::println);
    }

    public void writeFiles(String file) {
        System.out.println("Adding file " + file + " to marketing resources");
        files.add(file);
    }
}
