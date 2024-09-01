package faang.school.godbless.BJS2_25366_Task_1;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private List<String> files = new ArrayList<>();

    public void readFiles() {
        System.out.println("Getting files from Marketing Department");
        files.forEach(s -> System.out.printf("\t%s:\n", s));
    }

    public void addFile(String file) {
        files.add(file);
        System.out.printf("Added new file to marketing files: %s\n", file);
    }
}
