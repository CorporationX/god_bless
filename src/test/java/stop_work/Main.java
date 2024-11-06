package stop_work;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();
        Thread desinThread = new Thread(new DesignDepartment(designResources, marketingResources));
        Thread marketingThread = new Thread(new MarketingDepartment(designResources, marketingResources));
        desinThread.start();
        marketingThread.start();
        try {
            desinThread.join();
            marketingThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
