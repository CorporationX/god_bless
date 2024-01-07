package TheWorkIsWorth;

public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);


        for (int i = 0; i < 10; i++) {
            marketingResources.addMarketing("Marketing" + i);
            designResources.addDesign("Design" + i);
        }

        marketingDepartment.start();
        designDepartment.start();
    }
}
