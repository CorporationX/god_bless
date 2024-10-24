package school.faang.workstopped;

import java.util.List;

public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    // Конструктор для инициализации зависимостей
    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        // Чтение маркетинговых ресурсов
        System.out.println("Design is reading marketing resources...");
        List<String> marketingFiles = marketingResources.getFiles();
        marketingFiles.forEach(file -> System.out.println("Marketing File: " + file));

        // Запись данных в ресурсы дизайна
        System.out.println("Design is adding a file to its resources...");
        designResources.addFile("Design Sketch");
        System.out.println("Design has successfully added 'Design Sketch' to its resources.");
    }
}

