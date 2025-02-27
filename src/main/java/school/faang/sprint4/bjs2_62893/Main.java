package school.faang.sprint4.bjs2_62893;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResource = new MarketingResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResource, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResource, designResources);

        Thread marketingThread = new Thread(marketingDepartment);
        Thread designThread = new Thread(designDepartment);

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
