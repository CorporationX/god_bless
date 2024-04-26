package faang.school.godbless.concurrency.standingWork;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MarketingDepartment extends Thread {
    private final MarketingResources resources = new MarketingResources();

    public void doSomeWorkOnMarketing() {
        synchronized (resources) {
            log.info("Work has begun on the marketing strategy of the project.");
            resources.addNewFile("Marketing_strategy_plan.txt");

            printMarketingResources();

            log.info("The marketing department goes to design resources.");
            Organization.designDepartment.printDesignResources();

            log.info("The marketing strategy of the project was updated.");
        }
    }

    public void printMarketingResources() {
        synchronized (resources) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                log.info("The work on the marketing strategy was interrupted.");
            }

            resources.lsAll();
        }
    }
}
