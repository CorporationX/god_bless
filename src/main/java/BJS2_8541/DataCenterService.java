package BJS2_8541;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }
    public void allocateResources(ResourceRequest request) {
        Optional<Server> isValid = dataCenter.getServers().stream()
                .filter((server -> server.getLoad() + request.getLoad() <= server.getMaxLoad())).findFirst();
        isValid.orElseThrow().allocateLoad(request.getLoad());
    }

    public void releaseResources(ResourceRequest request) {
        Optional<Server> isValid = dataCenter.getServers().stream()
                .filter((server -> server.getLoad() > request.getLoad())).findFirst();
        isValid.orElseThrow().releaseLoad(request.getLoad());
    }
}
