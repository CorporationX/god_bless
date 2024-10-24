package school.faang.workstopped;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketing = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment design = new DesignDepartment(designResources, marketingResources);

        Thread marketingThread = new Thread(marketing);
        Thread designThread = new Thread(design);

        marketingThread.start();
        designThread.start();
    }
}


