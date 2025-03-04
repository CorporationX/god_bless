package school.faang.naughtwoBJS264555.resources;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class Resources {
    @Getter private List<String> resourceList = new CopyOnWriteArrayList<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void writeResource(String recourse) {
        resourceList.add(recourse);
        log.info("File '{}' added", recourse);
    }

    public void readResources() {
        lock.readLock().lock();
        log.info("List of files: ");
        resourceList.forEach(resource -> log.info("{}", resource));
    }
}
