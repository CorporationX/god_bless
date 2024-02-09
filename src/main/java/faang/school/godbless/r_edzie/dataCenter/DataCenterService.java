package faang.school.godbless.r_edzie.dataCenter;

import java.util.List;

public class DataCenterService implements OptimizationStrategy {
    private DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

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
            }
        }
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

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double totalLoad = this.getTotalServerLoad();
        double optimizedLoad = totalLoad / servers.size();

        servers.forEach(server -> server.setLoad(optimizedLoad));
    }
}
