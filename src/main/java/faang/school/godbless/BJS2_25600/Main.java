package faang.school.godbless.BJS2_25600;

public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);

        Thread marketingThread = new Thread(marketingDepartment, "Отдел маркетинга");
        Thread designThread = new Thread(designDepartment, "Отдел дизайна");

        marketingThread.start();
        designThread.start();
    }
}
