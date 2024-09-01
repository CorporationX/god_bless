package faang.school.godbless.BJS2_25358;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MarketingResources {
    private final List<String> marketingResources = generateMarketingResources(5);
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

    public List<String> generateMarketingResources(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> "MarketingContent" + i)
                .collect(Collectors.toList());
    }
}
