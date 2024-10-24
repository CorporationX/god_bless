package school.faang.workstopped;

public class DesignDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public DesignDepartment(MarketingResources marketingResources, DesignResources designResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        synchronized (marketingResources) {
            System.out.println("Design Department: Trying to read from Marketing Resources...");
            marketingResources.readFiles();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (designResources) {
                System.out.println("Design Department: Writing to Design Resources...");
                designResources.addFile("New Product Design");
            }
        }
    }
}
