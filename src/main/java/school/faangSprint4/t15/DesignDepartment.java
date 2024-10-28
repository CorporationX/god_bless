package school.faangSprint4.t15;

public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (marketingResources) {
                marketingResources.readFiles();
                synchronized (designResources) {
                    designResources.writeFile("design_update.txt");
                }
            }
        }
    }
}