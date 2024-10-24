package school.faang.workstopped;

public class MarketingDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("Marketing Department: Trying to read from Design Resources...");
            designResources.readFiles();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (marketingResources) {
                System.out.println("Marketing Department: Writing to Marketing Resources...");
                marketingResources.addFile("Marketing Analysis Report");
            }
        }
    }
}
