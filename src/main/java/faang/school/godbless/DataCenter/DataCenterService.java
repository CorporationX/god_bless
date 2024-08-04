package faang.school.godbless.DataCenter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DataCenterService implements OptimizationStrategy {

    private final DataCenter dataCenter = new DataCenter();

    public void addServerToDataCenter(final Server server) {
        dataCenter.getSERVERS().add(server);
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
        double toAllocate = request.getLoad();
        for (Server server : dataCenter.getSERVERS()) {
            server.setLoad(server.getLoad() + toAllocate);
            toAllocate = 0;
            if (server.getLoad() > server.getMAX_LOAD()) {
                toAllocate = server.getLoad() - server.getMAX_LOAD();
                server.setLoad(server.getMAX_LOAD());
            } else break;
        }
        if (toAllocate != 0) {
            System.out.println("Серверам не хватило мощности, что бы обработать весь запрос");
        }
    }

    public void releaseResources(ResourceRequest request) {
        double toRelease = request.getLoad();
        for (Server server : dataCenter.getSERVERS()) {
            server.setLoad(server.getLoad() - toRelease);
            if (server.getLoad() < 0) {
                toRelease = server.getLoad() * -1;
                server.setLoad(0);
            } else break;
        }
    }


    @Override
    public void optimize() {                                 //ну короче он пытается распределить нагрузку равномерно между всеми серверами (насколько это возможно)
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
