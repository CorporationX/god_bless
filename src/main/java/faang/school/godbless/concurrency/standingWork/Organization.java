package faang.school.godbless.concurrency.standingWork;

import java.util.concurrent.CompletableFuture;

public class Organization {

    public static DesignDepartment designDepartment;
    public static MarketingDepartment marketingDepartment;

    public static void main(String[] args) {
        marketingDepartment = new MarketingDepartment();
        designDepartment = new DesignDepartment();

        var designWork = CompletableFuture.runAsync(designDepartment::doSomeWorkOnDesign);
        var marketingWork = CompletableFuture.runAsync(marketingDepartment::doSomeWorkOnMarketing);

         CompletableFuture.allOf(designWork, marketingWork).join();
    }
}
