package faang.school.godbless.BJS2_25366_Task_1;

public class DesignDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        synchronized (designResources) {
            designResources.addFile("Design_Draft_1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (marketingResources) {
                marketingResources.readFiles();
            }
        }
    }
}