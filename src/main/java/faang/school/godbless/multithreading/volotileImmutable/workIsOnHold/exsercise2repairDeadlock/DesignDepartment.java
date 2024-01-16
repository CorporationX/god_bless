package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.exsercise2repairDeadlock;

public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        System.out.println("Original MARKETING files called from DESIGN DEPARTMENT.class: " + marketingResources.readAllFiles());
        System.out.println("Original DESIGN files called from DESIGN DEPARTMENT.class: " + designResources.readAllFiles());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        designResources.addFile("newFile-Design1.txt");
        System.out.println("Added new file from DESIGN DEPARTMENT.");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        System.out.println("Final MARKETING files called from DESIGN DEPARTMENT.class: " + marketingResources.readAllFiles());
        System.out.println("Final DESIGN files called from DESIGN DEPARTMENT.class: " + designResources.readAllFiles());
    }
}
