package school.faang.sprint4.task_63111;

import school.faang.sprint4.task_63111.department.Department;
import school.faang.sprint4.task_63111.department.DesignDepartment;
import school.faang.sprint4.task_63111.department.MarketingDepartment;
import school.faang.sprint4.task_63111.resources.DesignResources;
import school.faang.sprint4.task_63111.resources.MarketingResources;
import school.faang.sprint4.task_63111.resources.Resources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Resources designResources = new DesignResources();
        Resources marketingResources = new MarketingResources();

        designResources.write("file1");
        marketingResources.write("file2");

        Department design = new DesignDepartment(marketingResources, designResources);
        Department marketing = new MarketingDepartment(designResources, marketingResources);


        IntStream.range(0, 5)
                .forEach(num -> {
                    EXECUTOR.submit(design);
                    EXECUTOR.submit(marketing);
                });

        closeExecutor();
    }

    private static void closeExecutor() {
        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(15, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
                System.out.println("15 секунд Карл, возможно deadlock)");
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }
    }
}
