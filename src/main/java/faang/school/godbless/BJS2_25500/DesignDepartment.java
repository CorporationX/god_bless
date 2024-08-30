package faang.school.godbless.BJS2_25500;

public class DesignDepartment extends ThreadDepartment {

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        super(designResources, marketingResources);
    }

    @Override
    public void run() {
        Resources designResources = this.getDesignResources();
        Resources marketingResources = this.getMarketingResources();
        this.process(designResources, marketingResources);
    }
}
