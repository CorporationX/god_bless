package school.faang.work.is.in.place;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();
        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        for (int i = 0; i < 10; i++) {
            designResources.addFileName("file" + i + ".txt");
            marketingResources.addFileName("file" + i + ".txt");
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(marketingDepartment);
        executorService.submit(designDepartment);
        executorService.shutdown();
    }
}
