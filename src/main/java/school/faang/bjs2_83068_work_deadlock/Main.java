package school.faang.bjs2_83068_work_deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources(new ArrayList<>());
        DesignResources designResources = new DesignResources(new ArrayList<>());

        Thread design = new Thread(new DesignDepartment(designResources, marketingResources));
        Thread marketing = new Thread(new MarketingDepartment(marketingResources, designResources));

        design.start();
        marketing.start();

        try {
            design.join();
            marketing.join();
            log.info("All departments completed work!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
