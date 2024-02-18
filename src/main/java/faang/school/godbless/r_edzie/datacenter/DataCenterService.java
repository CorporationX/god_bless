package faang.school.godbless.r_edzie.datacenter;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public void addServer(Server server) {
        this.dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        this.dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        List<Server> servers = this.dataCenter.getServers();

        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }

        return totalEnergyConsumption;
    }

    public double getTotalServerLoad() {
        double totalServerLoad = 0;
        List<Server> servers = this.dataCenter.getServers();

        for (Server server : servers) {
            totalServerLoad += server.getLoad();
        }

        return totalServerLoad;
    }

    public void allocateResources(ResourceRequest request) {
        double load = request.getLoad();
        List<Server> servers = this.dataCenter.getServers();

        for (Server server : servers) {
            double residualLoad = server.getMaxLoad() - server.getLoad();

            if (residualLoad >= load) {
                server.setLoad(server.getLoad() + load);
                break;
            } else {
                server.setLoad(server.getLoad() + residualLoad);
                load = load - residualLoad;
            }
        }
    }

    public void optimize(OptimizationStrategy optimization) {
        optimization.optimize(this.dataCenter);
    }

    public void releaseResources(ResourceRequest request) {
        double releaseLoad = request.getLoad();

        List<Server> servers = this.dataCenter.getServers();

        for (Server server : servers) {

            if (releaseLoad == 0) {
                break;
            }

            double serverLoad = server.getLoad();

            if (serverLoad > releaseLoad) {
                server.setLoad(serverLoad - releaseLoad);
                releaseLoad = 0;
            } else {
                server.setLoad(0);
                releaseLoad -= serverLoad;
            }
        }
    }
}
