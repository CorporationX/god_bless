package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.Timer;
import java.util.TimerTask;

@Getter
@Setter
public class DataCenterService {

    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
       dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(){
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption).sum();
    }

    public void allocateResources(ResourceRequest request) {
        double load = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.canAllocate(load)) {
                server.allocate(load);
                return;
            }
        }
        throw new RuntimeException("No server can handle the requested load.");
    }

    public void releaseResources(ResourceRequest request) {
        double load = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() >= load) {
                server.release(load);
                return;
            }
        }
        throw new RuntimeException("No server has enough load to release.");
    }


    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }

    public void periodicOptimization() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                optimize();
            }
        }, 0, 30 * 60 * 1000);
    }
}