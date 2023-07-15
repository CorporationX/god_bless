package faang.school.godbless.sprint5.multithreading_conc.task6_work.task2;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {

    @Getter
    private List<String> files = new ArrayList<>();

    private List<String> filesFromMarketingResources = new ArrayList<>();

    private MarketingResources marketingResources;

    @Getter
    private ReadWriteLock lockDesigner = new ReentrantReadWriteLock();

    public void addMarketingResources(MarketingResources marketingResources) {
        this.marketingResources = marketingResources;

    }

    @SneakyThrows
    public void readFiles() {
        marketingResources.getLockMarketing().readLock().lock();
        try {
            marketingResources.getFiles().forEach(file -> System.out.println("DesignResources read file: " + file));
        } finally {
            marketingResources.getLockMarketing().readLock().unlock();
        }
    }

    public void addFile(String file) {
        lockDesigner.writeLock().lock();
        try {
            files.addAll(filesFromMarketingResources);
            System.out.println("added file: " + file + " to design resources");
        } finally {
            lockDesigner.writeLock().unlock();
        }

    }
}
