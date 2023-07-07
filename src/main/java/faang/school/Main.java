package faang.school;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        marketingDepartment.start();
        designDepartment.start();
        try {
            marketingDepartment.join();
            designDepartment.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
