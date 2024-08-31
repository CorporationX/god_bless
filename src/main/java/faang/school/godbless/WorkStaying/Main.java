package faang.school.godbless.WorkStaying;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        designResources.addFile("designShtukas");
        marketingResources.addFile("marketingShtukas");

        marketingDepartment.start();
        designDepartment.start();
    }
}
