package faang.school.godbless.BJS2_25600;

public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        synchronized (marketingResources) {
            marketingResources.addFile("Marketing Plan");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (designResources) {
                designResources.getFiles();
            }
        }
    }
}
