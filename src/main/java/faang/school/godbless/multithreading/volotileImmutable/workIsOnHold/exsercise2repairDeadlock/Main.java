package faang.school.godbless.multithreading.volotileImmutable.workIsOnHold.exsercise2repairDeadlock;

public class Main {
    public static void main(String[] args) {
        MarketingResources marketingResources = new MarketingResources();
        DesignResources designResources = new DesignResources();

        marketingResources.addFile("firstMarketingResources.txt");
        designResources.addFile("firstDesignResources.txt");

        new Thread(new MarketingDepartment(designResources, marketingResources)).start();
        new Thread(new DesignDepartment(designResources, marketingResources)).start();

    }
}
