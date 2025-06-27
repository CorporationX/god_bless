package school.faang.bjs2_83059.deadlock;

import school.faang.bjs2_83059.resources.DesignResources;
import school.faang.bjs2_83059.resources.MarketingResources;

public class MainWithDeadlock {
    public static void main(String[] args) {
        DesignResources design = new DesignResources();
        MarketingResources marketing = new MarketingResources();

        Thread marketingThread = new Thread(new MarketingDepartmentWithDeadlock(design, marketing));
        Thread designThread = new Thread(new DesignDepartmentWithDeadlock(design, marketing));

        marketingThread.start();
        designThread.start();
    }
}
