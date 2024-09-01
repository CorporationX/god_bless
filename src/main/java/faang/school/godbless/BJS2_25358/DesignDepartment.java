package faang.school.godbless.BJS2_25358;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    MarketingResources marketingResources;
    DesignResources designResources;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            List<String> mrList = marketingResources.getMarketingResources();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            designResources.addDesignResource(mrList.get(ThreadLocalRandom.current().nextInt(mrList.size())));
        }
        System.out.println("Design resources now: " + designResources.getDesignResources());
    }
}
