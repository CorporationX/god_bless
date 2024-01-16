package faang.school.godbless.work_standings;

public class MarketingDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        synchronized (designResources) {
            designResources.readFiles();
            synchronized (marketingResources) {
                marketingResources.addFile("New file");
            }
        }
    }
}
