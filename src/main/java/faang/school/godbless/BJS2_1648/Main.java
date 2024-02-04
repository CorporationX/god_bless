package faang.school.godbless.BJS2_1648;

import faang.school.godbless.BJS2_1648.resources.DesignResources;
import faang.school.godbless.BJS2_1648.resources.MarketingResources;
import faang.school.godbless.BJS2_1648.thread.DesignDepartment;
import faang.school.godbless.BJS2_1648.thread.MarketingDepartment;

public class Main {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        designDepartment.start();
        marketingDepartment.start();


    }
}
