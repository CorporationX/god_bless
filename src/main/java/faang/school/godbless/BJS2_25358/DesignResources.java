package faang.school.godbless.BJS2_25358;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignResources {
    private final ReadWriteLock designLock = new ReentrantReadWriteLock();
    private final List<String> designResources = new ArrayList<>() {{
        add("DesignContent1");
        add("DesignContent2");
        add("DesignContent3");
        add("DesignContent4");
        add("DesignContent5");
    }};

    public void addDesignResource(String designResource) {
        designLock.writeLock().lock();
        designResources.add(designResource);
        designLock.writeLock().unlock();
    }

    public List<String> getDesignResources() {
        designLock.readLock().lock();
        List<String> result = new ArrayList<>(designResources);
        designLock.readLock().unlock();
        return result;
    }
}
