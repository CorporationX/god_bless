package faang.school.godbless.data.center;

import faang.school.godbless.data.center.optimization.strategy.OptimizationStrategy;
import faang.school.godbless.data.center.service.DataCenterService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OptimizationScheduler {

    private static final int PERIOD_OPTIMIZATION_IN_MINUTES = 30;

    private final DataCenterService dataCenterService;
    private final OptimizationStrategy strategyOne;
    private final OptimizationStrategy strategyTwo;
    private boolean useFirstStrategy = true;
    private final ScheduledExecutorService scheduler;

    public OptimizationScheduler(DataCenterService dataCenterService, OptimizationStrategy strategyOne, OptimizationStrategy strategyTwo) {
        this.dataCenterService = dataCenterService;
        this.strategyOne = strategyOne;
        this.strategyTwo = strategyTwo;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startOptimizationRoutine() {
        scheduler.scheduleAtFixedRate(() -> {
            if (useFirstStrategy) {
                dataCenterService.setOptimizationStrategy(strategyOne);
            } else {
                dataCenterService.setOptimizationStrategy(strategyTwo);
            }
            dataCenterService.optimize();
            useFirstStrategy = !useFirstStrategy;
        }, 0, PERIOD_OPTIMIZATION_IN_MINUTES, TimeUnit.MINUTES);
    }
}


