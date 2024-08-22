package faang.school.godbless.data.center;

import faang.school.godbless.data.center.service.DataCenterService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OptimizationScheduler {

    private static final int PERIOD_OPTIMIZATION_IN_MINUTES = 30;

    private final DataCenterService dataCenterService;
    private final ScheduledExecutorService scheduler;

    public OptimizationScheduler(DataCenterService dataCenterService) {
        this.dataCenterService = dataCenterService;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startOptimizationRoutine() {
        scheduler.scheduleAtFixedRate(dataCenterService::optimize,
                0, PERIOD_OPTIMIZATION_IN_MINUTES, TimeUnit.MINUTES);
    }
}


