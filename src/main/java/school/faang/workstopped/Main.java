package school.faang.workstopped;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);

        Thread marketingThread = new Thread(marketingDepartment);
        Thread designThread = new Thread(designDepartment);

        marketingThread.start();
        designThread.start();
    }
}

