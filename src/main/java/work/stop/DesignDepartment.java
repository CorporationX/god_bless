package work.stop;

import java.util.concurrent.locks.ReadWriteLock;

public class DesignDepartment extends CustomThread {

    DesignDepartment(MarketingResources marketingResources, DesignResources designResources, ReadWriteLock lock) {
        super(lock, designResources, marketingResources);
    }

    @Override
    public void run() {
        this.getLock().writeLock().lock();
        this.getDesignResources().writeFile("Отдел дизайна приступил к работе");
        this.getLock().writeLock().unlock();

        this.getLock().readLock().lock();
        this.getMarketingResources().readFiles();
        this.getLock().readLock().unlock();

        this.getLock().writeLock().lock();
        this.getDesignResources().writeFile("Отдел дизайна добавил файл после блокировки ресурса маркетинга");
        this.getLock().writeLock().unlock();
    }
}
