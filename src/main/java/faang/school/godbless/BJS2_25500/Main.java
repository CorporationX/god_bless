package faang.school.godbless.BJS2_25500;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> files = List.of("File 1", "File 2", "File 3");
        MarketingResources marketingResources = new MarketingResources(new ArrayList<>(files));
        DesignResources designResources = new DesignResources(new ArrayList<>(files));

        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        marketingDepartment.start();
        designDepartment.start();

        try {
            marketingDepartment.join();
            designDepartment.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Result:");
        System.out.println(marketingResources.getFiles());
        System.out.println(designResources.getFiles());
    }
}
