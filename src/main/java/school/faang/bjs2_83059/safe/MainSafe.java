package school.faang.bjs2_83059.safe;

import school.faang.bjs2_83059.resources.DesignResources;
import school.faang.bjs2_83059.resources.MarketingResources;

public class MainSafe {
    public static void main(String[] args) {
        DesignResources design = new DesignResources();
        MarketingResources marketing = new MarketingResources();

        Thread marketingThread = new Thread(new MarketingDepartmentSafe(design, marketing));
        Thread designThread = new Thread(new DesignDepartmentSafe(design, marketing));

        marketingThread.start();
        designThread.start();
    }
}
