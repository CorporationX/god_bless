package work.waiting.departments;

import lombok.NonNull;
import work.waiting.Main;
import work.waiting.department_resources.Resources;

import java.util.concurrent.locks.ReadWriteLock;

public class DesignDepartment extends ThreadDepartment {
    public DesignDepartment(@NonNull Resources marketingResources,
                            @NonNull Resources designResources,
                            @NonNull ReadWriteLock lock) {
        super(marketingResources, designResources, lock);
    }

    @Override
    public void run() {
        for (int i = 0; i < Main.FILES_COUNT; i++) {
            lock.readLock().lock();
            String file = marketingResources.getFile();
            lock.readLock().unlock();
            lock.writeLock().lock();
            designResources.addFile(file);
            lock.writeLock().unlock();
        }
    }
}
