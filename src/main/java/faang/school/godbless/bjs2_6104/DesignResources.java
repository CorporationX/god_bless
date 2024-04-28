package faang.school.godbless.bjs2_6104;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class DesignResources {

    @Getter
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<String> resources = new ArrayList<>();

    public void addResource(String resource) {
        synchronized (resources) {
            try {
                Thread.sleep(1000);
                resources.add(resource);
                log.info("{} was added to Design list", resource);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printResources() {
        synchronized (resources) {
            try {
                log.info("Design resources print: ");
                Thread.sleep(1000);
                resources.forEach(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
