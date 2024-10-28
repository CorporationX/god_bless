package school.faang.workSuspended.Deadlock;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;
    private final CountDownLatch designLatch;
    private final CountDownLatch marketingLatch;

    @Override
    public void run() {
        try {
            marketingLatch.await();
            synchronized (marketingResources) {
                System.out.println("Design Department is reading marketing files...");
                List<String> marketingFiles = marketingResources.getMarketingFiles();
                synchronized (designResources) {
                    System.out.println("Design Department is adding marketing files to design files...");
                    for (String file : marketingFiles) {
                        designResources.addFile(file);
                    }
                }
            }
            designLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("Design Department is interrupted", e);

        }
    }
}
