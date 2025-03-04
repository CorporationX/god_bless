package school.faang.naughtwoBJS264555;

import lombok.extern.slf4j.Slf4j;
import school.faang.naughtwoBJS264555.department.DesignDepartment;
import school.faang.naughtwoBJS264555.department.MarketingDepartment;
import school.faang.naughtwoBJS264555.resources.DesignResources;
import school.faang.naughtwoBJS264555.resources.MarketingResources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int N_THREADS = 2;
    private static final int TIMEOUT = 2;

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        designResources.writeResource("1");
        designResources.writeResource("2");
        MarketingResources marketingResources = new MarketingResources();
        marketingResources.writeResource("3");
        marketingResources.writeResource("4");

        MarketingDepartment marketing = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment design = new DesignDepartment(designResources, marketingResources);

        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        executorService.submit(marketing);
        executorService.submit(design);
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
                log.info("Threads are interrupted");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        marketing.getResourcesOfThis().readResources();
        design.getResourcesOfThis().readResources();
    }
}
