package school.faang.task_51415;

public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public DesignDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        marketingResources.readFiles();
        designResources.addFile("Product Design Document");
    }
}
