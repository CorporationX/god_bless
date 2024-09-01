package faang.school.godbless.workisstopping;

public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        marketingDepartment.start();
        designDepartment.start();
    }
}