package bjs2_93306;

import bjs2_93306.departments.DesignDepartment;
import bjs2_93306.departments.MarketingDepartment;
import bjs2_93306.resources.DesignResources;
import bjs2_93306.resources.MarketingResources;

public class MainDeadlock {
    public static void main(String[] args) {
        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();

        Thread marketingThread = new Thread(new MarketingDepartment(marketingResources, designResources));
        Thread designThread = new Thread(new DesignDepartment(designResources, marketingResources));

        marketingThread.start();
        designThread.start();
    }
}