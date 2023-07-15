package faang.school.godbless.workBlockedTask2;

public class MarketingDepartment extends Thread{
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        marketingResources.readFiles();
        System.out.println("MarketingDepartment is reading MarketingResources.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        designResources.addFile("new_design.jpg");
        System.out.println("MarketingDepartment has added a new file to DesignResources.");
    }

}
