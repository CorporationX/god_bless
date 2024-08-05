package faang.school.godbless.BJS2_19800.service;

import faang.school.godbless.BJS2_19800.model.DataCenter;
import faang.school.godbless.BJS2_19800.model.ResourceRequest;
import faang.school.godbless.BJS2_19800.model.Server;
import faang.school.godbless.BJS2_19800.operationsOptimization.LoadBalancingOptimizationStrategy;
import lombok.Data;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Data
public class DataCenterService {

    private DataCenter dataCenter;
    private LoadBalancingOptimizationStrategy loadBalancingOptimizationStrategy;

    public DataCenterService() {
        this.dataCenter = new DataCenter();
    }

    public void addServer(Server server) {
        dataCenter.getServerList().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServerList().remove(server);
    }

    public Double getTotalEnergyConsumption() {
        List<Server> listOfServers = dataCenter.getServerList();
        double totalEnergyConsumption = 0;
        for (Server server : listOfServers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public boolean allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServerList()) {
            if (server.getMaxLoad() - server.getLoad() >= request.getLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
            }
            return true;
        }
        return false;
    }

    public boolean releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServerList()) {
            if (server.getLoad() >= request.getLoad()) {
                server.setLoad(server.getLoad() - request.getLoad());
            }
            return true;
        }
        return false;
    }

    public void scheduledOptimizationSevers() {
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                loadBalancingOptimizationStrategy.optimize(dataCenter);
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1800000);
    }
}
