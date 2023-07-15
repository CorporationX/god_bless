package faang.school.godbless.workBlockedTask1;

public class DesignDepartment extends Thread{
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("DesignDepartment has locked DesignResources");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("DesignDepartment is waiting to access MarketingResources");
            synchronized (marketingResources) {
                System.out.println("DesignDepartment has locked MarketingResources");
            }
        }
    }
}
