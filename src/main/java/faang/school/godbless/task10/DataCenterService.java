package faang.school.godbless.task10;

import lombok.Data;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class DataCenterService {
    public final DataCenter dataCenter;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream().map(Server::getEnergyConsumption).reduce(0.0, Double::sum);
    }

    public double getMaxLoad() {
        return dataCenter.getServers().stream().map(Server::getMaxLoad).reduce(0.0, Double::sum);
    }

    public void allocateResources(ResourceRequest request) {
        if (getTotalEnergyConsumption() > getMaxLoad() + request.getLoad()) {
            releaseResources(request);
        } else for (Server server : dataCenter.getServers()) {
            if (server.getEnergyConsumption() > getMaxLoad() + request.getLoad()) {
                server.setEnergyConsumption(server.getEnergyConsumption() + request.getLoad());
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            server.setEnergyConsumption(server.getEnergyConsumption() - request.getLoad());
            allocateResources(request);
        }
    }

    public void startOptimization() {
        executorService.scheduleAtFixedRate(() -> optimizationStrategy.optimize(dataCenter), 0, 30, TimeUnit.MINUTES);
        executorService.shutdown();
    }
}
