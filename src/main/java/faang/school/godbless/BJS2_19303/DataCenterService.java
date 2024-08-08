package faang.school.godbless.BJS2_19303;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataCenterService {
    final DataCenter dataCenter;
    final OptimizationStrategy optimizationStrategy;
    final Timer optimizationTimer;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy, Timer optimizationTimer) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
        this.optimizationTimer = new Timer(true);
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getTotalEnergy();
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        List<Server> servers = dataCenter.getServers();
        double load = resourceRequest.getLoad();
        double occupiedLoad = servers.stream().mapToDouble(Server::getLoad).sum();
        double totalMaxLoad = servers.stream().mapToDouble(Server::getMaxLoad).sum();
        if (load + occupiedLoad > totalMaxLoad){
            throw new IllegalArgumentException("Load exceeds max load");
        }

        for (Server server : dataCenter.getServers()) {
            double additionalLoad = Math.min(server.getMaxLoad() - server.getLoad(), load);
            server.setLoad(additionalLoad + server.getLoad());
            load -= additionalLoad;
            if (additionalLoad <= 0){
                break;
            }
        }
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        double load = resourceRequest.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() < load){
                load -= server.getLoad();
                server.setLoad(0);
            }else {
                server.setLoad(server.getLoad() - load);
                break;
            }
        }
    }

    public void startOptimization() {
        optimizationTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                optimizationStrategy.optimize(dataCenter);
            }
        }, 0, 5000);
    }
}
