package faang.school.godbless.BJS2_25446;

public class DesignDepartment extends ThreadDepartment {

    public DesignDepartment(MarketingResources marketingResources, DesignResources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        synchronized (getMarketingResources()) {
            getMarketingResources().getResources();
            synchronized (getDesignResources()) {
                getDesignResources().getResources();
            }
        }
    }
}
