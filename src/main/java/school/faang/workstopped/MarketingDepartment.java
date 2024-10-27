package school.faang.workstopped;

import java.util.List;

public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    // Конструктор для инициализации зависимостей
    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        // Чтение данных из ресурсов дизайна
        System.out.println("Marketing is reading design resources...");
        List<String> designFiles = designResources.getFiles(); // Получаем список дизайн-файлов
        designFiles.forEach(file -> System.out.println("Design File: " + file)); // Печатаем названия файлов

        // Запись данных в маркетинговые ресурсы
        System.out.println("Marketing is adding a file to its resources...");
        marketingResources.addFile("Marketing Analysis"); // Добавляем новый файл в маркетинговые ресурсы
        System.out.println("Marketing has successfully added 'Marketing Analysis' to its resources.");
    }
}

