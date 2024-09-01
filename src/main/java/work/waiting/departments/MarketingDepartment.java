package work.waiting.departments;

import lombok.NonNull;
import work.waiting.Main;
import work.waiting.department_resources.Resources;

import java.util.concurrent.locks.ReadWriteLock;

public class MarketingDepartment extends ThreadDepartment {
    public MarketingDepartment(@NonNull Resources marketingResources,
                               @NonNull Resources designResources,
                               @NonNull ReadWriteLock lock) {
        super(marketingResources, designResources, lock);
    }

    @Override
    public void run() {
        for (int i = 0; i < Main.FILES_COUNT; i++) {
            lock.readLock().lock();
            String file = designResources.getFile();
            lock.readLock().unlock();
            lock.writeLock().lock();
            marketingResources.addFile(file);
            lock.writeLock().unlock();
        }
    }
}
