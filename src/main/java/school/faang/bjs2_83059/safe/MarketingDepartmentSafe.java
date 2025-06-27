package school.faang.bjs2_83059.safe;

import lombok.AllArgsConstructor;
import school.faang.bjs2_83059.resources.DesignResources;
import school.faang.bjs2_83059.resources.MarketingResources;

@AllArgsConstructor
public class MarketingDepartmentSafe implements Runnable {
    private final DesignResources design;
    private final MarketingResources marketing;

    @Override
    public void run() {
        design.readFiles("Marketing");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        marketing.writeFile("marketing_plan_safe.pdf");
    }
}
