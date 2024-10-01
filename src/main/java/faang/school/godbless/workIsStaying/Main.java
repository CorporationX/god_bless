package faang.school.godbless.workIsStaying;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MarketingDepartment marketingDepartment = new MarketingDepartment();
        DesignDepartment designDepartment = new DesignDepartment();

        marketingDepartment.start();
        designDepartment.start();

        Thread.sleep(2_000);

        System.out.println(MarketingResources.getFiles().equals(DesignResources.getFiles()));
    }
}
