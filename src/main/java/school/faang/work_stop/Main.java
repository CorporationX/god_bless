package school.faang.work_stop;

public class Main {

    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);

        Thread threadMarketing = new Thread(marketingDepartment);
        Thread threadDesign = new Thread(designDepartment);

        threadMarketing.start();
        threadDesign.start();
    }
}
