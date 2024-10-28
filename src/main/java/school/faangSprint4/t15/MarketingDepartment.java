package school.faangSprint4.t15;

public class MarketingDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (designResources) {
                designResources.readFiles();
                synchronized (marketingResources) {
                    marketingResources.writeFile("marketing_analysis.txt");
                }
            }
        }
    }
}