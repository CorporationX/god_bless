package faang.school.godbless.jobIsStack;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        designDepartment.start();
        marketingDepartment.start();
    }
}
