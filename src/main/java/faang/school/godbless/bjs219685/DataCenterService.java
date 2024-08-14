package faang.school.godbless.bjs219685;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.deleteServer(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getTotalEnergyConsumption();
    }

    public void allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getMaxLoad() - server.getLoad() >= request.getLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                return;
            }
        }
        throw new RuntimeException("Not enough resources");
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
           if (server.getLoad() >= request.getLoad()) {
               server.setLoad(server.getLoad() - request.getLoad());
               return;
           }

        }
        throw new RuntimeException("No suitable server to release resources");
    }

    public void printServersState() {
        for (Server server : dataCenter.getServers()) {
            System.out.println(server);
        }
    }

    public void optimize() {
        this.optimizationStrategy.optimize(this.dataCenter);
    }
}
