package faang.school.godbless.javaHashMap.dataCenter;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenterService {
    private final DataCenter dataCenter;
    private final OptimizationStrategy optimizationStrategy;

    public DataCenterService() {
        dataCenter = new DataCenter();
        optimizationStrategy = new LoadBalancingOptimizationStrategy();
    }

    public void allocateResources(ResourceRequest request) {
        for(Server server : dataCenter.getServers()) {
            if(server.takeLoad(request.getLoad())) {
                //Sever successfully took new load
                System.out.println("Resources were successfully allocated");
                return;
            }
        }

        System.out.println("There is no available servers to allocate these RESOURCES");
    }

    public void releaseResources(ResourceRequest request) {
        for(Server server : dataCenter.getServers()) {
            if(server.releaseLoad(request.getLoad())) {
                //Sever successfully released load
                System.out.println("Resources were successfully released");
                return;
            }
        }

        System.out.println("There is no loaded servers");
    }

    public boolean addServer(double maxLoad, double energyConsumption) {
        return dataCenter.getServers().add(new Server(0, maxLoad, energyConsumption));
    }

    public void removeServer(double load, double maxLoad, double energyConsumption) {
        List<Server> seversToBeRemoved = dataCenter.getServers().stream()
                .filter(server -> server.equals(
                        new Server(load, maxLoad, energyConsumption))
                ).toList();

        dataCenter.getServers().removeAll(seversToBeRemoved);
    }

    public void printAllServersInfo() {
        dataCenter.getServers().forEach(System.out::println);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;

        for(Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }

        return totalEnergyConsumption;
    }

    public double getTotalLoad() {
        double totalLoad = 0.0;

        for(Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }

        return totalLoad;
    }

    public void optimizeDataCenter() {
        optimizationStrategy.optimize(dataCenter);
    }
}
