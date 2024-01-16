package faang.school.godbless.multi_con.task4work.subtask2;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        MarketingDepartment marketing = new MarketingDepartment(designResources, marketingResources);
        DesignDepartment design = new DesignDepartment(designResources, marketingResources);

        marketing.start();
        design.start();
    }
}
