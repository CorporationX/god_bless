package school.faang.bjs2_83059.safe;

import lombok.AllArgsConstructor;
import school.faang.bjs2_83059.resources.DesignResources;
import school.faang.bjs2_83059.resources.MarketingResources;

@AllArgsConstructor
public class DesignDepartmentSafe implements Runnable {
    private final DesignResources design;
    private final MarketingResources marketing;

    @Override
    public void run() {
        marketing.readFiles("Design");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        design.writeFile("design_safe.png");
    }
}
