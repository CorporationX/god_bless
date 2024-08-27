package faang.school.godbless.BJS2_25500;

public class DesignDepartment extends ThreadDepartment {

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        super(designResources, marketingResources);
    }

    @Override
    public void run() {
        DesignResources designResources = this.getDesignResources();
        MarketingResources marketingResources = this.getMarketingResources();

        synchronized (designResources) {
            designResources.printFiles();
        }

        synchronized (marketingResources) {
            String file = marketingResources.readFile();
            designResources.writeFile(file);
        }
    }
}
