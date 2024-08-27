package faang.school.godbless.BJS2_25500;

public class MarketingDepartment extends ThreadDepartment {

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        super(designResources, marketingResources);
    }

    @Override
    public void run() {
        MarketingResources marketingResources = this.getMarketingResources();
        synchronized (marketingResources) {
            DesignResources designResources = this.getDesignResources();
            designResources.printFiles();

            synchronized (designResources) {
                String file = designResources.readFile();
                marketingResources.writeFile(file);
            }
        }
    }
}
