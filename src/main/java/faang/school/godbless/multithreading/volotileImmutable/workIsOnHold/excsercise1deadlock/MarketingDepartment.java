package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.excsercise1deadlock;

public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        synchronized (marketingResources) {
            System.out.println("Marketing Department captured Marketing-resources");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
            System.out.println("Marketing Department try capture Design-resources");
            synchronized (designResources) {
                System.out.println("Marketing Department captured Marketing-resources");
            }
        }
    }
}
