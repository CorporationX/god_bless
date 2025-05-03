package dead.lock;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        synchronized (designResources) {
            synchronized (marketingResources) {
                for (String marketingFile : marketingResources.getMarketingFiles()) {
                    designResources.addFile(marketingFile);
                }
            }
        }
    }
}
