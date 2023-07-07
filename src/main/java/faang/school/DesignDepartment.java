package faang.school;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class DesignDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    @SneakyThrows
    public void run() {
        synchronized (marketingResources) {
            System.out.println("DesignDepartment locked MarketingResources");
            Thread.sleep(1000);

            synchronized (designResources) {
                System.out.println("DesignDepartment locked DesignResources");
                System.out.println(designResources.getPaths());
                System.out.println("DesignDepartment releasing DesignResources");
            }
            System.out.println("DesignDepartment releasing MarketingResources");
        }
    }
}
