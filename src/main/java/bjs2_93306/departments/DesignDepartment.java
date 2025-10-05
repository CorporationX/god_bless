package bjs2_93306.departments;

import bjs2_93306.resources.DesignResources;
import bjs2_93306.resources.MarketingResources;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        synchronized (marketingResources) {
            System.out.println("Дизайн читает маркетинговые ресурсы...");
            marketingResources.getFiles()
                    .forEach(file -> System.out.printf("Файл маркетинга: %s%n", file));

            synchronized (designResources) {
                System.out.println("Дизайн добавляет файл в свои ресурсы...");
                designResources.addFile("Design Sketch");
            }
        }
    }
}