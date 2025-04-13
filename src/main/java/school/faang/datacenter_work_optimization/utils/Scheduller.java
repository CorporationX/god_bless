package school.faang.datacenter_work_optimization.utils;

import school.faang.datacenter_work_optimization.model.DataCenter;
import school.faang.datacenter_work_optimization.services.DataCenterService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduller {
    private static final long INITIAL_DELAY = 0;
    private static final long PERIOD = 30;

    private void takeTimeToOptimize(DataCenter dataCenter) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable optimize = () ->
            DataCenterService.callOptimization(dataCenter);

        scheduler.scheduleAtFixedRate(optimize, INITIAL_DELAY, PERIOD, TimeUnit.MINUTES);
    }
}
