package faang.school.godbless.BJS2_19295;

import lombok.NoArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class OptimizationScheduler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

    protected void start(int timeDelayInSeconds, DataCenterService dataCenterService, OptimizationStrategy optimizationStrategy) {
        scheduler.scheduleAtFixedRate(() -> {
            long now = System.currentTimeMillis() / 1000;
            System.out.println("Execution time: " + now);
            try {
                optimizationStrategy.optimize(dataCenterService.getDataCenter());
                System.out.println("Optimized successfully");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Optimization failed");
            }
        }, 0, timeDelayInSeconds, TimeUnit.SECONDS);
    }
}
