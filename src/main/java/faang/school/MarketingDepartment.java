package faang.school;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    @SneakyThrows
    public void run() {
        synchronized (designResources) {
            System.out.println("MarketingDepartment locked DesignResources");
            Thread.sleep(1000);
            synchronized (marketingResources) {
                System.out.println("MarketingDepartment locked MarketingResources");
                System.out.println(marketingResources.getPaths());
                System.out.println("MarketingDepartment releasing MarketingResources");
            }
            System.out.println("MarketingDepartment releasing DesignResources");
        }
    }
}
