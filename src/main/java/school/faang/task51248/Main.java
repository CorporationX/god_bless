package school.faang.task51248;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Department designDepartment = new DesignResources(new HashSet<>(
                Set.of("фото", "картинка")
        ));
        Department marketingDepartment = new MarketingDepartment(new HashSet<>(
                Set.of("реклама", "цена")
        ));
        designDepartment.setDepartmentAnalyze(marketingDepartment);
        marketingDepartment.setDepartmentAnalyze(designDepartment);

        CompletableFuture.allOf(CompletableFuture.supplyAsync(() -> {
            designDepartment.run();
            return designDepartment;
        }), CompletableFuture.supplyAsync(() -> {
            marketingDepartment.run();
            return marketingDepartment;
        }).thenAccept(Department::readFiles)).join();
    }
}
