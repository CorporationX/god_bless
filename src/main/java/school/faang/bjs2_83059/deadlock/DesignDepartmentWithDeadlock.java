package school.faang.bjs2_83059.deadlock;

import lombok.AllArgsConstructor;
import school.faang.bjs2_83059.resources.DesignResources;
import school.faang.bjs2_83059.resources.MarketingResources;

@AllArgsConstructor
public class DesignDepartmentWithDeadlock implements Runnable {
    private final DesignResources design;
    private final MarketingResources marketing;

    @Override
    public void run() {
        synchronized (marketing) {
            System.out.println("Design locked MarketingResources");
            marketing.readFiles("Design");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (design) {
                System.out.println("Design locked DesignResources");
                design.writeFile("new_logo.png");
            }
        }
    }
}