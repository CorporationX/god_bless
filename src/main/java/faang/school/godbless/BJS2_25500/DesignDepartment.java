package faang.school.godbless.BJS2_25500;

public class DesignDepartment extends ThreadDepartment {

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        super(designResources, marketingResources);
    }

    @Override
    public void run() {
        DesignResources designResources = this.getDesignResources();
        synchronized (designResources) {
            MarketingResources marketingResources = this.getMarketingResources();
            marketingResources.printFiles();

            synchronized (marketingResources) {
                String file = marketingResources.readFile();
                designResources.writeFile(file);
            }
        }
    }
}
