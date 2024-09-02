package faang.school.godbless.BJS2_25374;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Resources marketing = new Resources();
        Resources design = new Resources();

        DesignDepartment designDepartment = new DesignDepartment(marketing, design);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketing, design);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(designDepartment);
        executor.execute(marketingDepartment);
        executor.shutdown();
    }
}
