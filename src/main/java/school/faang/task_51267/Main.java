package school.faang.task_51267;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        List<String> filesImmutable = List.of("file1.txt", "file2.txt", "file3.txt");
        DesignResources designResources = new DesignResources(new ArrayList<>(filesImmutable));
        MarketingResources marketingResources = new MarketingResources(new ArrayList<>(filesImmutable));

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);

        Thread task1 = new Thread(designDepartment.startTask);
        Thread task2 = new Thread(marketingDepartment.startTask);
        task1.start();
        task2.start();

        task1.join();
        task2.join();
    }
}
