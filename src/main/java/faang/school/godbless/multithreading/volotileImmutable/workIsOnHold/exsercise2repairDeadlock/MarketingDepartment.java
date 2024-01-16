package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.exsercise2repairDeadlock;

public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.marketingResources = marketingResources;
        this.designResources = designResources;
    }

    @Override
    public void run() {
        System.out.println("Original MARKETING files called from MARKETING DEPARTMENT.class: " + marketingResources.readAllFiles());
        System.out.println("Original DESIGN files called from MARKETING DEPARTMENT.class: " + designResources.readAllFiles());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

        marketingResources.addFile("newFile-Marketing1.txt");
        System.out.println("Added new file from MARKETING DEPARTMENT.");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        System.out.println("Final MARKETING files called from MARKETING DEPARTMENT.class: " + marketingResources.readAllFiles());
        System.out.println("Final DESIGN files called from MARKETING DEPARTMENT.class: " + designResources.readAllFiles());

    }
}
