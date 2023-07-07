package faang.school;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();
        MarketingDepartment marketingDepartment = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);

        var addThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                designResources.addPath(Integer.toBinaryString(i));
                marketingResources.addPath(Integer.toBinaryString(i + 9));
            }
        });
        addThread.start();
        try {
            Thread.sleep(20);
            marketingDepartment.start();
            designDepartment.start();
            marketingDepartment.join();
            designDepartment.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
