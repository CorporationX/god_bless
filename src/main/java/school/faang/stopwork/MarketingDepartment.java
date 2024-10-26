package school.faang.stopwork;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> files;
        System.out.println("Маркетинг читает дизайн ресурсы...");
        files = designResources.getFiles();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Маркетинг добавляет файл в свои ресурсы...");
        for (String file : files) {
            marketingResources.addFile(file);
        }
        marketingResources.getFiles().forEach(System.out::println);
    }
}