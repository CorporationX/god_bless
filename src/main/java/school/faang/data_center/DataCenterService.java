package school.faang.data_center;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Setter
@AllArgsConstructor
public class DataCenterService {

    private final DataCenter dataCenter;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServers().removeIf(serverFromDataCenter -> Objects.equals(serverFromDataCenter, server));
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public boolean allocateResources(ResourceRequest resourceRequest) {
        checkForAllocation(resourceRequest.load());
        double freeResources = dataCenter.getFreeLoad();
        return freeResources - resourceRequest.load() >= 0;
    }

    public void releaseResources(ResourceRequest resourceRequest) {
        double requestedLoad = resourceRequest.load();
        checkForRelease(requestedLoad);

        for (Server server : dataCenter.getServers()) {

            double calcRelease = Math.min(server.getLoad(), requestedLoad);
            server.setLoad(server.getLoad() - calcRelease);
            requestedLoad -= calcRelease;

            if (requestedLoad <= 0) {
                break;
            }
        }
    }

    public void optimize(OptimizationStrategy strategy) {
        if (strategy != null) {
            strategy.optimize(dataCenter);
        }
    }

    private void checkForAllocation(double requestedLoad) {
        if (dataCenter.getTotalMaxLoad() - dataCenter.getTotalLoad() < requestedLoad) {
            throw new RuntimeException("Your data center doesn`t have enough resources");
        }
    }

    private void checkForRelease(double requestedLoad) {
        if (dataCenter.getTotalMaxLoad() < requestedLoad) {
            throw new RuntimeException("Your data center doesn`t have enough resources");
        }
    }
}
