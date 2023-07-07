package faang.school;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        System.out.println(designResources.getPaths());
        System.out.println(marketingResources.getPaths());
    }
}
