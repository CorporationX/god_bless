package faang.school.godbless.workStands;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final DesignResources designResources = new DesignResources();
        final MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(() -> {
            marketingResources.addRecourse("New marketing resource");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Design resources: {}", designResources.getResources().toString());
            log.info("MarketingDepartment work is done");
        });

        DesignDepartment designDepartment = new DesignDepartment(() -> {
            designResources.addRecourse("New design resource");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Marketing resources: {}", marketingResources.getResources().toString());
            log.info("DesignDepartment work is done");
        });

        marketingDepartment.start();
        designDepartment.start();
    }
}
