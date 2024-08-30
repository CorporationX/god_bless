package faang.school.godbless.BJS2_25358;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources {
    private final List<String> marketingResources = new ArrayList<>() {{
        add("MarketingContent1");
        add("MarketingContent2");
        add("MarketingContent3");
        add("MarketingContent4");
        add("MarketingContent5");
    }};
    private final ReadWriteLock marketingLock = new ReentrantReadWriteLock();

    public void addMarketingResource(String marketingResource) {
        marketingLock.writeLock().lock();
        marketingResources.add(marketingResource);
        marketingLock.writeLock().unlock();
    }

    public List<String> getMarketingResources() {
        marketingLock.readLock().lock();
        List<String> result = new ArrayList<>(marketingResources);
        marketingLock.readLock().unlock();
        return result;
    }
}
