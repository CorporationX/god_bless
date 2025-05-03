package workiswaiting;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        DesignResources designResources = new DesignResources(List.of("design_file.txt"));
        MarketingResources marketingResources = new MarketingResources(List.of("marketing_research.txt"));

        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        Thread designThread = new Thread(designDepartment, "DesignThread");
        Thread marketingThread = new Thread(marketingDepartment, "MarketingThread");

        designThread.start();
        marketingThread.start();

        Thread.sleep(5000);

        System.out.println("\nПрограмма завершается, возможно, произошел дедлок.");
        System.exit(0);
    }
}
