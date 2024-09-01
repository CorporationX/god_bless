package faang.school.godbless.BJS2_25366_Task_1;

public class MarketingDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        synchronized (marketingResources) {
            marketingResources.addFile("Marketing_Report_1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (designResources) {
                designResources.readFiles();
            }
        }
    }
}