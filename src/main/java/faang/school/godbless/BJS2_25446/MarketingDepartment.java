package faang.school.godbless.BJS2_25446;

public class MarketingDepartment extends ThreadDepartment {

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        synchronized (getDesignResources()) {
            getMarketingResources().getResources();
            synchronized (getMarketingResources()) {
                getDesignResources().getResources();
            }
        }
    }
}
