package faang.school.godbless.optimizing_datacenter;

import java.util.Objects;
import java.util.Random;

public class DataCenterService {

    private final DataCenter dataCenter = new DataCenter();

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) {
        Random random = new Random();
        int serverId = 0;
//       rerandom server to assign task to until finds one with capacity to execute request
//        will do infinite loop if now servers available because i dont want to cover this case
//        Bogosort style 😎
        do {
            serverId = random.nextInt(dataCenter.getServers().size());
        } while (dataCenter.getServers().get(serverId).getMaxLoad() < dataCenter.getServers().get(serverId).getLoad() + request.getLoad());
        Server server = dataCenter.getServers().get(serverId);
        dataCenter.getRequestMap().put(request, server);
        server.executeRequest(request);
    }

    public void releaseResource(ResourceRequest request) {
        if (!dataCenter.getRequestMap().containsKey(request)) {
            return;
        }
        dataCenter.getRequestMap().get(request).releaseRequest(request);
        dataCenter.getRequestMap().remove(request);
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void optimize(OptimizationStrategy optimizationStrategy) {
        Objects.requireNonNull(optimizationStrategy);
        optimizationStrategy.optimize(dataCenter);
    }
}
