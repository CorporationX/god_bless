package bjs2_93306.departments;

import bjs2_93306.resources.SafeDesignResources;
import bjs2_93306.resources.SafeMarketingResources;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SafeDesignDepartment implements Runnable {
    private final SafeDesignResources designResources;
    private final SafeMarketingResources marketingResources;

    @Override
    public void run() {
        System.out.println("Дизайн читает маркетинговые ресурсы...");
        marketingResources.getFiles()
                .forEach(file -> System.out.printf("Файл маркетинга: %s%n", file));

        System.out.println("Дизайн добавляет файл в свои ресурсы...");
        designResources.addFile("Design Sketch");
    }
}