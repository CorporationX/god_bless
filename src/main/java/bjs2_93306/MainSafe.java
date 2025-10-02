package bjs2_93306;

import bjs2_93306.departments.SafeDesignDepartment;
import bjs2_93306.departments.SafeMarketingDepartment;
import bjs2_93306.resources.SafeDesignResources;
import bjs2_93306.resources.SafeMarketingResources;

public class MainSafe {
    public static void main(String[] args) {
        SafeDesignResources designResources = new SafeDesignResources();
        SafeMarketingResources marketingResources = new SafeMarketingResources();

        Thread marketingThread = new Thread(new SafeMarketingDepartment(marketingResources, designResources));
        Thread designThread = new Thread(new SafeDesignDepartment(designResources, marketingResources));

        marketingThread.start();
        designThread.start();
    }
}