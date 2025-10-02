package bjs2_93306.departments;

import bjs2_93306.resources.SafeDesignResources;
import bjs2_93306.resources.SafeMarketingResources;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SafeMarketingDepartment implements Runnable {
    private final SafeMarketingResources marketingResources;
    private final SafeDesignResources designResources;

    @Override
    public void run() {
        System.out.println("Маркетинг читает дизайн ресурсы...");
        designResources.getFiles()
                .forEach(file -> System.out.printf("Файл дизайна: %s%n", file));

        System.out.println("Маркетинг добавляет файл в свои ресурсы...");
        marketingResources.addFile("Marketing Analysis");
    }
}