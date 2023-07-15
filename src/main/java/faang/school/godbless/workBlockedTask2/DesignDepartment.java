package faang.school.godbless.workBlockedTask2;

public class DesignDepartment extends Thread{
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        designResources.readFiles();
        System.out.println("DesignDepartment is reading DesignResources.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        marketingResources.addFile("new_report.pdf");
        System.out.println("DesignDepartment has added a new file to MarketingResources.");
    }

}
