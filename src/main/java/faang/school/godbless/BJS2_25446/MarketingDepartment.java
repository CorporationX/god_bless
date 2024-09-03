package faang.school.godbless.BJS2_25446;

public class MarketingDepartment extends ThreadDepartment {

    public MarketingDepartment(Resources marketingResources, Resources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        getMarketingResources().getResources();
        getDesignResources().getResources();
    }
}
