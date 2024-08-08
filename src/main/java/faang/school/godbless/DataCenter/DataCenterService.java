package faang.school.godbless.DataCenter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DataCenterService implements OptimizationStrategy {

    private final DataCenter dataCenter = new DataCenter();

    public void addServerToDataCenter(final Server server) {
        dataCenter.addServer(server);
    }

    public void deleteServerFromDataCenterById(int id, boolean forceDelete) {
        Server server = dataCenter.getServerById(id);
        if (server == null)
        {
            System.out.println("Server with id " + id + " not found");
        }
        else
        {
            if (forceDelete) {
                dataCenter.deleteServer(server);
            }
            else {
                double potentialMaxLoad = getMaximumLoad() - server.getMaxLoad();
                double loadToAllocate = server.getLoad();
                if (getTotalLoad() > potentialMaxLoad) {
                    System.out.println("Невозможно удалить сервер. Сначала снизьте нагрузку на " + (getTotalLoad() - potentialMaxLoad));
                }
                else {
                    allocateResources(new ResourceRequest(loadToAllocate));
                    dataCenter.deleteServer(server);
                }
            }
        }
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getMaximumLoad() {
        double maxLoad = 0;
        for (Server server : dataCenter.getServers()) {
            maxLoad += server.getMaxLoad();
        }
        return maxLoad;
    }

    public double getTotalLoad() {
        double totalLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public void allocateResources(ResourceRequest request) {
        double loadToAllocate = request.getLoad();
        double freeResources = getMaximumLoad() - getTotalLoad();
        if (freeResources < loadToAllocate) {
            System.out.println("Серверам не хватит мощности что бы обработать такой запрос!");
        }
        else
        {
            for (Server server : dataCenter.getServers()) {
                double currentServerLoad = server.getLoad();
                if ((currentServerLoad + loadToAllocate) > server.getMaxLoad()) {
                    loadToAllocate -= server.getMaxLoad() - server.getLoad();
                    server.setLoad(server.getMaxLoad());
                } else {
                    server.setLoad(server.getLoad() + loadToAllocate);
                    break;
                }
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        double toRelease = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double loadAfterRelease = server.getLoad() - toRelease;
            if (loadAfterRelease < 0) {
                toRelease = loadAfterRelease * -1;
                server.setLoad(0);
            } else {
                break;
            }
        }
    }


    @Override
    public void optimize() {
        double dividor = dataCenter.getServers().size();
        double loadToBalance = getTotalLoad();
        double balanced = loadToBalance / dividor;

        for (Server server : dataCenter.getServers()) {
            server.setLoad(balanced);
            dividor--;
            loadToBalance -= balanced;
            if (server.getLoad() > server.getMaxLoad()) {
                double overLoad = server.getLoad() - server.getMaxLoad();
                server.setLoad(server.getMaxLoad());
                balanced = loadToBalance + overLoad / dividor;
            }
        }
    }
}
