package faang.school.godbless.WorkIsStopped;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();
        DesignDepartment design = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketing = new MarketingDepartment(designResources, marketingResources);

        design.start();
        marketing.start();

        design.join();
        marketing.join();
    }
}
