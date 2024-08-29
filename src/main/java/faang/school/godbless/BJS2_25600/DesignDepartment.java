package faang.school.godbless.BJS2_25600;

public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public DesignDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        synchronized (designResources) {
            designResources.addFile("Product Design Draft");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (marketingResources) {
                marketingResources.getFiles();
            }
        }
    }
}
