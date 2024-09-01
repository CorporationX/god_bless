package faang.school.godbless.BJS2_25308;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public record MarketingResources(List<String> files, ReadWriteLock lock){
    public MarketingResources() {
        this(new ArrayList<>(), new ReentrantReadWriteLock());
    }

    public void readFiles(){
        lock.readLock().lock();
        try {
            log.info("Reading files...");
            Thread.sleep(2000);
            files.forEach(System.out::println);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error during reading: {}", e.getMessage());
        } finally {
            lock.readLock().unlock();
            log.info("Finished reading.");
        }
    }

    public void addFile(String file){
        lock.writeLock().lock();
        try {
            log.info("Adding file: {}", file);
            Thread.sleep(2000);
            files.add(file);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error during writing: {}", e.getMessage());
        } finally {
            lock.writeLock().unlock();
            log.info("Finished adding file.");
        }
    }
}
