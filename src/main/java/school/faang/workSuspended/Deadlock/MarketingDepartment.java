package school.faang.workSuspended.Deadlock;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;
    private final CountDownLatch designLatch;
    private final CountDownLatch marketingLatch;

    @Override
    public void run() {
        try {
            designLatch.await();
            synchronized (designResources) {
                System.out.println("Marketing Department is reading design files...");
                List<String> designFiles = designResources.getDesignFiles();
                synchronized (marketingResources) {
                    System.out.println("Marketing Department is adding design files to marketing files...");
                    for (String file : designFiles) {
                        marketingResources.addFile(file);
                    }
                }
            }
            marketingLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("Marketing Department is interrupted", e);
        }
    }
}
