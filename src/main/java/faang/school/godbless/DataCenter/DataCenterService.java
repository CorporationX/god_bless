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
        if (forceDelete)
        {
            dataCenter.deleteServer(server);
        }
        else
        {
            double potentialMaxLoad = getMaximumLoad() - server.getMAX_LOAD();
            double loadToAllocate = server.getLoad();
            if (getTotalLoad() > potentialMaxLoad)
            {
                System.out.println("Невозможно удалить сервер. Сначала снизьте нагрузку на " + (getTotalLoad() - potentialMaxLoad));
            }
            else
            {
                allocateResources(new ResourceRequest(loadToAllocate));
                dataCenter.deleteServer(server);
            }
        }
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getSERVERS()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getMaximumLoad() {
        double maxLoad = 0;
        for (Server server : dataCenter.getSERVERS()) {
            maxLoad += server.getMAX_LOAD();
        }
        return maxLoad;
    }

    public double getTotalLoad() {
        double totalLoad = 0;
        for (Server server : dataCenter.getSERVERS()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public void allocateResources(ResourceRequest request) {
        double loadToAllocate = request.getLoad();
        for (Server server : dataCenter.getSERVERS()) {
            double currentServerLoad = server.getLoad();
            if ((currentServerLoad + loadToAllocate) > server.getMAX_LOAD()) {
                loadToAllocate -= server.getMAX_LOAD() - server.getLoad();
                request.setLoad(loadToAllocate);
                server.setLoad(server.getMAX_LOAD());
            } else {
                server.setLoad(server.getLoad() + loadToAllocate);
                request.setLoad(0);
                break;
            }
        }
        if (!request.isRequestAllocated()) {
            System.out.println("Серверам не хватило мощности, что бы обработать весь запрос");
        }
    }

    public void releaseResources(ResourceRequest request) {
        double toRelease = request.getLoad();
        for (Server server : dataCenter.getSERVERS()) {
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
        double dividor = dataCenter.getSERVERS().size();
        double loadToBalance = getTotalLoad();
        double balanced = loadToBalance / dividor;

        for (Server server : dataCenter.getSERVERS()) {
            server.setLoad(balanced);
            dividor--;
            loadToBalance -= balanced;
            if (server.getLoad() > server.getMAX_LOAD()) {
                double overLoad = server.getLoad() - server.getMAX_LOAD();
                server.setLoad(server.getMAX_LOAD());
                balanced = loadToBalance + overLoad / dividor;
            }
        }
    }
}
