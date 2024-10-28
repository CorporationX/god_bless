package school.faangSprint4.t15;

public class MarketingDepartmentSafe implements Runnable {
    private final DesignResourcesSafe designResources;
    private final MarketingResourcesSafe marketingResources;

    public MarketingDepartmentSafe(DesignResourcesSafe designResources, MarketingResourcesSafe marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        while (true) {
            designResources.readFiles();
            marketingResources.writeFile("marketing_analysis.txt");
        }
    }
}