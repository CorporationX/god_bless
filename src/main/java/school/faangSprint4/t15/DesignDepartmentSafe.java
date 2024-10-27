package school.faangSprint4.t15;

public class DesignDepartmentSafe implements Runnable {
    private final DesignResourcesSafe designResources;
    private final MarketingResourcesSafe marketingResources;

    public DesignDepartmentSafe(DesignResourcesSafe designResources, MarketingResourcesSafe marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        while (true) {
            marketingResources.readFiles();
            designResources.writeFile("design_update.txt");
        }
    }
}