package school.BJS2_39344;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        for (int i = 0; i <= 10; i++) {
            marketingResources.addNameOfFile("Текст для маркетинга номер " + i);
            designResources.addNameOfFile("Текст для дизайна номер " + i);
        }

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(marketingDepartment);
        executor.execute(designDepartment);

        executor.shutdown();

    }
}