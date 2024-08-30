package faang.school.godbless.BJS2_25358;

public class Main {
    public static void main(String[] args) {
        MarketingResources mr = new MarketingResources();
        DesignResources dr = new DesignResources();
        DesignDepartment designDepartment = new DesignDepartment(mr, dr);
        MarketingDepartment marketingDepartment = new MarketingDepartment(mr, dr);
        new Thread(marketingDepartment).start();
        new Thread(designDepartment).start();
    }
}
