package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.excsercise1deadlock;

public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("Design Department captured Design-resources");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
            System.out.println("Design Department try capture Marketing-resources");
            synchronized (marketingResources) {
                System.out.println("Design Department captured Marketing-resources");
            }
        }
    }
}
