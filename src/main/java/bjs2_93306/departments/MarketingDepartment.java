package bjs2_93306.departments;

import bjs2_93306.resources.DesignResources;
import bjs2_93306.resources.MarketingResources;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("Маркетинг читает дизайн ресурсы...");
            designResources.getFiles()
                    .forEach(file -> System.out.printf("Файл дизайна: %s%n", file));

            synchronized (marketingResources) {
                System.out.println("Маркетинг добавляет файл в свои ресурсы...");
                marketingResources.addFile("Marketing Analysis");
            }
        }
    }
}