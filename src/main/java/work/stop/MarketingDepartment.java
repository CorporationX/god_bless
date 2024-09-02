package work.stop;

import java.util.concurrent.locks.ReadWriteLock;

public class MarketingDepartment extends CustomThread {

    MarketingDepartment(
        MarketingResources marketingResources,
        DesignResources designResources,
        ReadWriteLock lock
    ) {
        super(lock, designResources, marketingResources);
    }

    @Override
    public void run() {
        this.getLock().writeLock().lock();
        this.getMarketingResources().writeFile("Маркетинговый отдел приступил к работе");
        this.getLock().writeLock().unlock();

        this.getLock().readLock().lock();
        this.getDesignResources().readFiles();
        this.getLock().readLock().unlock();

        this.getLock().writeLock().lock();
        this.getMarketingResources().writeFile("Отдел маркетинга добавил файл после блокировки ресурса дизайнеров");
        this.getLock().writeLock().unlock();
    }
}
