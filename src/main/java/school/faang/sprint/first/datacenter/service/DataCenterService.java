package school.faang.sprint.first.datacenter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import school.faang.sprint.first.datacenter.model.DataCenter;
import school.faang.sprint.first.datacenter.model.ResourceRequest;
import school.faang.sprint.first.datacenter.model.Server;

import java.util.List;

@RequiredArgsConstructor
public class DataCenterService {
    private final OptimizationStrategy optimizationStrategy;

    public void optimize(DataCenter dataCenter) {
        optimizationStrategy.optimize(dataCenter);
    }

    public boolean addServer(@NonNull DataCenter dataCenter, @NonNull Server server) {
        if (isServerValid(server)) {
            List<Server> serversInDataCenter = dataCenter.getServers();
            if (serversInDataCenter.stream()
                    .noneMatch(serverInDataCenter -> serverInDataCenter.equals(server))) {
                serversInDataCenter.add(server);
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean removeServer(@NonNull DataCenter dataCenter, @NonNull Server server) {
        if (isServerValid(server)) {
            return dataCenter.getServers().remove(server);
        }
        return false;
    }

    public double getTotalEnergyConsumption(@NonNull DataCenter dataCenter) {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }


    public boolean allocateResources(@NonNull DataCenter dataCenter, @NonNull ResourceRequest request) {
        double plannedLoad = request.getLoad();

        if (plannedLoad <= 0) {
            throw new IllegalArgumentException("Запрос на распределяемую нагрузку не может быть <= 0");
        }

        List<Server> servers = dataCenter.getServers();

        for (Server server : servers) {
            if (plannedLoad == 0) {
                return true;
            }

            double serverCurrentLoad = server.getLoad();
            double serverMaxLoad = server.getMaxLoad();
            double availableLoad = serverMaxLoad - serverCurrentLoad;
            if (availableLoad > 0) {
                if (plannedLoad - availableLoad > 0) {
                    plannedLoad -= availableLoad;
                    server.setLoad(serverMaxLoad);
                } else if (plannedLoad - availableLoad < 0) {
                    server.setLoad(serverCurrentLoad + plannedLoad);
                    plannedLoad = 0;
                    break;
                } else {
                    break;
                }
            }
        }

        return plannedLoad == 0;
    }

    public void releaseResources(@NonNull DataCenter dataCenter, @NonNull ResourceRequest request) {
        double plannedUnLoad = request.getLoad();

        if (plannedUnLoad < 0) {
            throw new IllegalArgumentException("Запрос на освобождаемую нагрузку не может быть <= 0");
        }

        List<Server> servers = dataCenter.getServers();

        for (Server server : servers) {
            if (plannedUnLoad == 0) {
                break;
            }

            double serverCurrentLoad = server.getLoad();
            if (plannedUnLoad - serverCurrentLoad > 0) {
                plannedUnLoad -= serverCurrentLoad;
                server.setLoad(0);
            } else if (plannedUnLoad - serverCurrentLoad < 0) {
                server.setLoad(serverCurrentLoad - plannedUnLoad);
                plannedUnLoad = 0;
            } else {
                break;
            }
        }
    }

    private boolean isServerValid(@NonNull Server server) {
        double serverLoad = server.getLoad();
        double serverMaxLoad = server.getMaxLoad();

        return serverLoad > 0 && serverMaxLoad > 0 && server.getEnergyConsumption() > 0 && serverMaxLoad >= serverLoad;
    }
}
