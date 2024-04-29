package faang.school.godbless.workisstoped;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class MarketingResources {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private List<String> resources = new ArrayList<>();

    public void addResource(String resource) {
        lock.writeLock().lock();
        try {
            Thread.sleep(1000);
            resources.add(resource);
            log.info("{} was added to Marketing list", resource);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void printResources() {
        lock.readLock().lock();
        try {
            log.info("Marketing resources print: ");
            Thread.sleep(1000);
            resources.forEach(System.out::println);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        } finally {
            lock.readLock().unlock();
        }
    }
}
