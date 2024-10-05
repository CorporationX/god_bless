package optimizing_the_work_of_the_data_center;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Timer;
import java.util.TimerTask;

@Data
@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    private static final int OPTIMIZATION_DELAY = 1800000;

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.allocateLoad(request.getLoad())) {
                return true;
            }
        }
        return false;
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            server.releaseLoad(request.getLoad());
        }
    }

    private void startOptimizationTask() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                optimizeDataCenter();
            }
        }, 0, OPTIMIZATION_DELAY);
    }

    private void optimizeDataCenter() {
        optimizationStrategy.optimize(dataCenter);
    }
}

