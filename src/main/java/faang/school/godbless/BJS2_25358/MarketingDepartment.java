package faang.school.godbless.BJS2_25358;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    MarketingResources marketingResources;
    DesignResources designResources;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            List<String> drList = designResources.getDesignResources();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            marketingResources.addMarketingResource((drList.get(ThreadLocalRandom.current().nextInt(drList.size()))));
        }
        System.out.println("Marketing resources now: " + marketingResources.getMarketingResources());
    }
}
