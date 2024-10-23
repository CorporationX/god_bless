package school.faang.stopwork;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> files;
        System.out.println("Дизайн читает маркетинговые ресурсы...");
        files = marketingResources.getFiles();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Дизайн добавляет файл в свои ресурсы...");
        for (String file : files) {
            designResources.addFile(file);
        }
        designResources.getFiles().forEach(System.out::println);
    }
}