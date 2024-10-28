package school.faangSprint4.t15;

public class DeadlockDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация дедлока:");
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        Thread marketingThread = new Thread(new MarketingDepartment(designResources, marketingResources), "Marketing");
        Thread designThread = new Thread(new DesignDepartment(designResources, marketingResources), "Design");

        marketingThread.start();
        designThread.start();

        System.out.println("\nДемонстрация решения с использованием ReadWriteLock:");
        DesignResourcesSafe designResourcesSafe = new DesignResourcesSafe();
        MarketingResourcesSafe marketingResourcesSafe = new MarketingResourcesSafe();

        Thread marketingThreadSafe = new Thread(
                new MarketingDepartmentSafe(designResourcesSafe, marketingResourcesSafe),
                "Marketing-Safe"
        );
        Thread designThreadSafe = new Thread(
                new DesignDepartmentSafe(designResourcesSafe, marketingResourcesSafe),
                "Design-Safe"
        );
        marketingThreadSafe.start();
        designThreadSafe.start();
    }
}