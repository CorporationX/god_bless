package faang.school.godbless.task13;

import lombok.ToString;

import java.util.ArrayList;

@ToString
public class DataCenterService implements OptimizationStrategy{
    private DataCenter dataCenter;
    private static final int HIGHEST_ACCEPTABLE_LOAD = 80;
    private static final int LEAST_ACCEPTABLE_LOAD = 20;

    public DataCenterService() {
        this.dataCenter = new DataCenter(new ArrayList<>());
    }

    public void addServer() {
        dataCenter.getServers().add(new Server());
    }

    public void removeServer() {
        dataCenter.getServers().remove(dataCenter.getServers().size() - 1);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0d;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
         return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) {
        boolean hasSpace = false;
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() + request.getLoad() < HIGHEST_ACCEPTABLE_LOAD) {
                server.setLoad(server.getLoad() + request.getLoad());
                hasSpace = true;
                break;
            }
        }
        if (!hasSpace) {
            addServer();
        }
        optimize(dataCenter);

    }

    public void releaseResources(ResourceRequest request, DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() - request.getLoad() > LEAST_ACCEPTABLE_LOAD) {
                server.setLoad(server.getLoad() - request.getLoad());
                break;
            }
        }
        optimize(dataCenter);
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        double loadOfServers = 0;
        for (Server server : dataCenter.getServers()) {
            loadOfServers += server.getLoad();
        }
        if (loadOfServers / dataCenter.getServers().size() >= HIGHEST_ACCEPTABLE_LOAD) {
            dataCenter.getServers().add(new Server());
        } else if (loadOfServers / dataCenter.getServers().size() <= LEAST_ACCEPTABLE_LOAD) {
            dataCenter.getServers().remove(dataCenter.getServers().size() - 1);
        }
        for (Server server : dataCenter.getServers()) {
            server.setLoad(loadOfServers / dataCenter.getServers().size());
        }
    }
}
