package Concurrency_4;

public class Application {
    public static void main(String[] args) {
        MarketingDepartment marketingDepartment = new MarketingDepartment();
        DesignDepartment designDepartment = new DesignDepartment();
        for (int i = 0; i < 5; i++) {
            Thread threadMarketing = new Thread(marketingDepartment);
            Thread threadDesign = new Thread(designDepartment);
            threadMarketing.start();
            threadDesign.start();
        }
    }
}
