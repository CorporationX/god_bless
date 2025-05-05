package dead.lock;

public class Main {
    // Без gpt я бы это никогда не решил)
    public static void main(String[] args) throws InterruptedException {
        final DesignResources designResources = new DesignResources();
        final MarketingResources marketingResources = new MarketingResources();

        final Thread thread = new Thread(() -> new MarketingDepartment(designResources, marketingResources).run());
        final Thread thread1 = new Thread(() -> new DesignDepartment(designResources, marketingResources).run());

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
    }
}
