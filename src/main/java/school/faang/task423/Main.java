package school.faang.task423;

import school.faang.task423.department.DesignDepartment;
import school.faang.task423.department.MarketingDepartment;
import school.faang.task423.resources.DesignResources;
import school.faang.task423.resources.MarketingResources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        ExecutorService service = Executors.newFixedThreadPool(6);
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            int finalI = i;
            futures.add(service.submit(() -> {
                designResources.addFile("new fileD №" + finalI);
                marketingResources.addFile("new fileM №" + finalI);
            }));

        }
        for (int i = 0; i < futures.size(); i++) {
            try {
                futures.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e.getStackTrace().toString());
            }
        }


        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        futures.clear();
        futures.add(service.submit(marketingDepartment));
        futures.add(service.submit(designDepartment));

        for (int i = 0; i < futures.size(); i++) {
            try {
                futures.get(i).get();
            } catch (ExecutionException | InterruptedException e) {
                throw new IllegalStateException(e.getStackTrace().toString());
            }
        }

        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getStackTrace().toString());
        }

        System.out.println(marketingResources.getFiles().size());
        System.out.println(designResources.getFiles().size());
    }
}
