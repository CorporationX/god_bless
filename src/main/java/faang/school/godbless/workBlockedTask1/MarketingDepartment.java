package faang.school.godbless.workBlockedTask1;

public class MarketingDepartment extends Thread{
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        synchronized (marketingResources) {
            System.out.println("MarketingDepartment has locked MarketingResources");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("MarketingDepartment is waiting to access DesignResources");
            synchronized (designResources) {
                System.out.println("MarketingDepartment has locked DesignResources");
            }
        }
    }

}
