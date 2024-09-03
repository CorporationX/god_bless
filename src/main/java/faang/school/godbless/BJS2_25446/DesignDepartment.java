package faang.school.godbless.BJS2_25446;

public class DesignDepartment extends ThreadDepartment {

    public DesignDepartment(Resources marketingResources, Resources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        getDesignResources().getResources();
        getMarketingResources().getResources();
    }
}
