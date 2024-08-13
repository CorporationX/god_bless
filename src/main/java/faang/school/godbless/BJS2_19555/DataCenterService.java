package faang.school.godbless.BJS2_19555;

import java.util.Timer;

import faang.school.godbless.BJS2_19555.strategy.OptimizationStrategy;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.TimerTask;
import java.util.function.BiFunction;
import java.util.function.Predicate;

@AllArgsConstructor
public class DataCenterService {
    public Timer timer;

    public void addServer(DataCenter dataCenter, Server server) {
        if (dataCenter != null && server != null) {
            List<Server> servers = dataCenter.getServers();
            servers.add(server);
            dataCenter.getServerIndexes().put(server, servers.size() - 1);
        }
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        if (dataCenter != null && server != null) {
            int index = dataCenter.getServerIndexes().remove(server);
            dataCenter.getServers().remove(index);
        }
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        if (dataCenter != null) {
            return dataCenter.getServers().stream()
                    .mapToDouble(Server::getEnergyConsumption)
                    .sum();
        }
        return 0;
    }

    public void allocateResources(DataCenter dataCenter, ResourceRequest request) {
        if (dataCenter != null && request != null) {
            modifyLoad(dataCenter, request, server -> server.getAvailableLoad() >= request.getLoad(), Server::increaseLoad);
        }
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        if (dataCenter != null && request != null) {
            modifyLoad(dataCenter, request, server -> server.getLoad() >= request.getLoad(), Server::decreaseLoad);
        }
    }

    public void modifyLoad(DataCenter dataCenter, ResourceRequest request, Predicate<Server> condition,
                           BiFunction<Server, Double, Double> loadModifier) {
        if (dataCenter != null && request != null) {
            for (Server server : dataCenter.getServers()) {
                double currentLoad = server.getLoad();
                if (condition.test(server)) {
                    double newLoad = loadModifier.apply(server, request.getLoad());
                    server.changeEnergyConsumption(currentLoad, newLoad);
                    return;
                }
            }
        }
    }

    public void optimize(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        if (dataCenter != null && optimizationStrategy != null) {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    optimizationStrategy.optimize(dataCenter);
                }
            }, 0, 1800000);
        }
    }
}
