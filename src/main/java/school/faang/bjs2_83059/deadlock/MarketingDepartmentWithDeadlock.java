package school.faang.bjs2_83059.deadlock;

import lombok.AllArgsConstructor;
import school.faang.bjs2_83059.resources.*;

@AllArgsConstructor
public class MarketingDepartmentWithDeadlock implements Runnable {
    private final DesignResources design;
    private final MarketingResources marketing;

    @Override
    public void run() {
        synchronized (design) {
            System.out.println("Marketing locked DesignResources");
            design.readFiles("Marketing");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (marketing) {
                System.out.println("Marketing locked MarketingResources");
                marketing.writeFile("marketing_plan.pdf");
            }
        }
    }
}