package faang.school.godbless.sprint5.multithreading_conc.task6_work.task1_deadlock;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {

    @Getter
    private List<String> files = new ArrayList<>();

    private List<String> filesDesignResources = new ArrayList<>();

    private DesignResources designResources;

    public void addDesignResources(DesignResources designResources) {
        this.designResources = designResources;
    }

    @SneakyThrows
    public void addFilesFromDesignResources() {
        synchronized (designResources.getFiles()) {
            Thread.sleep(1000);
            synchronized (files) {
                files.addAll(files);
                System.out.println("All files added to marketing resources");
            }
        }
    }

    public void addFile(String file) {
        synchronized (files) {
            files.add(file);
            System.out.println("added file: " + file + " to marketing resources");
        }
    }
}
