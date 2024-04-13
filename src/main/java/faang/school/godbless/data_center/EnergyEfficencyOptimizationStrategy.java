package faang.school.godbless.data_center;

import java.util.Timer;
import java.util.TimerTask;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    private Timer timer;
    private long period;
    private DataCenter dataCenter;

    public EnergyEfficencyOptimizationStrategy(long period, DataCenter dataCenter) {
        this.period = period;
        this.dataCenter = dataCenter;
        this.timer = new Timer();
        scheduleOptimization();
    }

    private void scheduleOptimization() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                optimize(dataCenter);
            }
        }, 0, period * 60 * 1000);
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        System.out.println("Оптимизация");
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        Server server = new Server();
        double serverLoad = server.getLoad();
        double serverEnergyConsumption = server.getEnergyConsumption();

        if (serverLoad > 80) {
            dataCenterService.releaseResources(dataCenter, new ResourceRequest(20));
        }

        if (serverEnergyConsumption > 85) {
            dataCenterService.releaseResources(dataCenter, new ResourceRequest(20));
        }
    }
}
