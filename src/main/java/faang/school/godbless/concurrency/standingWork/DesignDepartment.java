package faang.school.godbless.concurrency.standingWork;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class DesignDepartment {
    private final DesignResources resources = new DesignResources();
    private final Object resourcesLock = new Object();

    public void doSomeWorkOnDesign() {
        synchronized (resourcesLock) {

            log.info("Work has begun on the design of the project.");
            addFileInDesignResources("design_ideas.txt");

            printDesignResources();

            log.info("The design department goes to marketing resources.");
            Organization.marketingDepartment.printMarketingResources();


            log.info("The design of the project was updated.");
        }
    }

    public synchronized void printDesignResources() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            log.info("The work on the design was interrupted.");
        }

        resources.lsAll();
    }

    public void addFileInDesignResources(@NonNull String newFile) {
        synchronized (resourcesLock) {
            resources.addNewFile(newFile);
        }
    }
}
