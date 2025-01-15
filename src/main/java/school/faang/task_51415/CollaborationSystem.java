package school.faang.task_51415;

public class CollaborationSystem {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);
        DesignDepartment designDepartment = new DesignDepartment(marketingResources, designResources);

        Thread marketingThread = new Thread(marketingDepartment);
        Thread designThread = new Thread(designDepartment);

        marketingThread.start();
        designThread.start();

        try {
            marketingThread.join();
            designThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Collaboration completed without deadlock.");
    }
}
