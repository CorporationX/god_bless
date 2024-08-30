package faang.school.godbless.BJS2_25500;

public class MarketingDepartment extends ThreadDepartment {

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        super(designResources, marketingResources);
    }

    @Override
    public void run() {
        Resources marketingResources = this.getMarketingResources();
        Resources designResources = this.getDesignResources();
        this.process(marketingResources, designResources);
    }
}
