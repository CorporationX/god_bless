package Concurrency_4;

public class Application {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        for (int i = 0; i < 5; i++) {
            Thread threadMarketing = new Thread(marketingDepartment);
            Thread threadDesign = new Thread(designDepartment);
            threadMarketing.start();
            threadDesign.start();
        }
    }
}
