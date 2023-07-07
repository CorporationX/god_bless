package faang.school.godbless.sprint5.multithreading_conc.task6_work.task2;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {

    @Getter
    private List<String> files = new ArrayList<>();

    private List<String> filesDesignResources = new ArrayList<>();

    private DesignResources designResources;

    @Getter
    private ReadWriteLock lockMarketing = new ReentrantReadWriteLock();

    public void addDesignResources(DesignResources designResources) {
        this.designResources = designResources;
    }

    @SneakyThrows
    public void readFiles() {
        designResources.getLockDesigner().readLock().lock();
        try {
            designResources.getFiles().forEach(file -> System.out.println("DesignResources read file: " + file));
        } finally {
            designResources.getLockDesigner().readLock().unlock();
        }
    }

    public void addFile(String file) {
        try {
            lockMarketing.writeLock().lock();
            files.add(file);
            System.out.println("added file: " + file + " to marketing resources");
        } finally {
            lockMarketing.writeLock().unlock();
        }
    }
}
