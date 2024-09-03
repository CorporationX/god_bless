package faang.school.godbless.BJS2_25446;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Resources marketingResources = new Resources(new ArrayList<>());
        Resources designResources = new Resources(new ArrayList<>());

        marketingResources.addResource("MarketingResource 1");
        marketingResources.addResource("MarketingResource 2");
        designResources.addResource("DesignResource 1");
        designResources.addResource("DesignResource 2");

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);

        marketingDepartment.start();
        designDepartment.start();

        try {
            marketingDepartment.join();
            designDepartment.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
