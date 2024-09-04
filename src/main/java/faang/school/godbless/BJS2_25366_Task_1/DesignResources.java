package faang.school.godbless.BJS2_25366_Task_1;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {
    private List<String> files = new ArrayList<>();

    public void readFiles() {
        System.out.println("Getting files from Design Department");
        files.forEach(s -> System.out.printf("\t%s:\n", s));
    }


    public void addFile(String fileName) {
        files.add(fileName);
        System.out.printf("Added Design Resource file: %s\n", fileName);
    }
}
