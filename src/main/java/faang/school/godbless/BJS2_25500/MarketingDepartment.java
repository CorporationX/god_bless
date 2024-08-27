package faang.school.godbless.BJS2_25500;

public class MarketingDepartment extends ThreadDepartment {

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        super(designResources, marketingResources);
    }

    @Override
    public void run() {
        MarketingResources marketingResources = this.getMarketingResources();
        DesignResources designResources = this.getDesignResources();

        synchronized (marketingResources) {
            designResources.printFiles();
        }

        synchronized (designResources) {
            String file = designResources.readFile();
            marketingResources.writeFile(file);
        }
    }
}
