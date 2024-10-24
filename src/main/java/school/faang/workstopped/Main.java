package school.faang.workstopped;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketing = new MarketingDepartment(designResources,marketingResources);
        DesignDepartment design = new DesignDepartment(marketingResources,designResources);

        Thread marketingThread = new Thread(marketing);
        Thread designThread = new Thread(design);

        marketingThread.start();
        designThread.start();
    }
}

