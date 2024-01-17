package Concurrency_4;

public class DesignDepartment implements Runnable {

    private DesignResources designResources;
    private MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        marketingResources.outPutFile(designResources);
    }

    public DesignResources getDesignResources() {
        return designResources;
    }

    public MarketingResources getMarketingResources() {
        return marketingResources;
    }
}
