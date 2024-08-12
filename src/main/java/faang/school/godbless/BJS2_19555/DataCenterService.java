package faang.school.godbless.BJS2_19555;

import java.util.Timer;

import faang.school.godbless.BJS2_19555.strategy.OptimizationStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.TimerTask;
import java.util.function.BiFunction;
import java.util.function.Predicate;

@AllArgsConstructor
public class DataCenterService {
    public Timer timer;

    public void addServer(@NonNull DataCenter dataCenter, @NonNull Server server) {
        List<Server> servers = dataCenter.getServers();
        servers.add(server);
        dataCenter.getServerIndexes().put(server, servers.size() - 1);
    }

    public void removeServer(@NonNull DataCenter dataCenter, @NonNull Server server) {
        int index = dataCenter.getServerIndexes().remove(server);
        dataCenter.getServers().remove(index);
    }

    public double getTotalEnergyConsumption(@NonNull DataCenter dataCenter) {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(@NonNull DataCenter dataCenter, @NonNull ResourceRequest request) {
        modifyLoad(dataCenter, request, server -> server.getAvailableLoad() >= request.getLoad(), Server::increaseLoad);
    }

    public void releaseResources(@NonNull DataCenter dataCenter, @NonNull ResourceRequest request) {
        modifyLoad(dataCenter, request, server -> server.getLoad() >= request.getLoad(), Server::decreaseLoad);
    }

    public void modifyLoad(@NonNull DataCenter dataCenter, @NonNull ResourceRequest request, Predicate<Server> condition,
                           BiFunction<Server, Double, Double> loadModifier) {
        for (Server server : dataCenter.getServers()) {
            double currentLoad = server.getLoad();
            if (condition.test(server)) {
                double newLoad = loadModifier.apply(server, request.getLoad());
                server.changeEnergyConsumption(currentLoad, newLoad);
                return;
            }
        }
    }

    public void optimize(@NonNull DataCenter dataCenter, @NonNull OptimizationStrategy optimizationStrategy) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                optimizationStrategy.optimize(dataCenter);
            }
        }, 0, 1800000);
    }
}
