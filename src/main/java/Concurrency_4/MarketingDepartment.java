package Concurrency_4;

public class MarketingDepartment implements Runnable {

    private MarketingResources marketingResources;
    private DesignResources designResources;

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        designResources.outPutFile(marketingResources);
    }

    public DesignResources getDesignResources() {
        return designResources;
    }

    public MarketingResources getMarketingResources() {
        return marketingResources;
    }
}
