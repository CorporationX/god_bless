package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.excsercise1deadlock;

public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        new Thread(new MarketingDepartment(designResources, marketingResources)).start();
        new Thread(new DesignDepartment(designResources, marketingResources)).start();

    }
}
