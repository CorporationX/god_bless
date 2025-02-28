package school.faang.theworkstands;

public class Main {

    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketing = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment design = new DesignDepartment(marketingResources, designResources);

        Thread marketingThread = new Thread(marketing);
        Thread designThread = new Thread(design);

        marketingThread.start();
        designThread.start();

        try {
            marketingThread.join();
            designThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
