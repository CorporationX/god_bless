package faang.school.godbless.work_standings;

public class DesignDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        synchronized (designResources) {
            marketingResources.readFiles();
            synchronized (marketingResources) {
                designResources.addFile("New file");
            }
        }
    }
}
