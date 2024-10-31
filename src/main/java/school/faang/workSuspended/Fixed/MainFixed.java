package school.faang.workSuspended.Fixed;

public class MainFixed {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();
        designResources.addFile("DesignFile1");
        designResources.addFile("DesignFile2");
        marketingResources.addFile("MarketingFile1");
        marketingResources.addFile("MarketingFile2");

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        Thread designThread = new Thread(designDepartment);
        Thread marketingThread = new Thread(marketingDepartment);

        designThread.start();
        marketingThread.start();
    }
}
