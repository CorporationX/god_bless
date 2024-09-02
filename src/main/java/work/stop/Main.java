package work.stop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources(new ArrayList<>(List.of(
            "File 1",
            "File 2",
            "File 3"
        )));

        MarketingResources marketingResources = new MarketingResources(new ArrayList<>(List.of(
            "3 File",
            "2 File",
            "1 File"
        )));

        ReadWriteLock lock = new ReentrantReadWriteLock();
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources, lock);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources, lock);

        marketingDepartment.start();
        designDepartment.start();

        try {
            marketingDepartment.join();
            designDepartment.join();
            System.out.println("Работа завершена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
