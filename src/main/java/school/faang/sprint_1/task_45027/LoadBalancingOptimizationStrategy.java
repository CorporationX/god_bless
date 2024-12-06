package school.faang.sprint_1.task_45027;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter, ResourceRequest request) {
        double availableLoad = request.getLoad();
        int totalServers = dataCenter.servers.size();
        double allocateLoad = availableLoad / totalServers;

        for (Server server : dataCenter.servers) {
            if (availableLoad > allocateLoad) {
                if ((server.getLoad() + allocateLoad) > server.getMaxLoad()) {
                    double requiredLoad = server.getMaxLoad() - server.getLoad();
                    availableLoad -= requiredLoad;
                    server.setLoad(server.getMaxLoad());
                    DataCenterService.allocatedLoads.put(server, requiredLoad);
                } else {
                    availableLoad -= allocateLoad;
                    server.setLoad(server.getLoad() + allocateLoad);
                    DataCenterService.allocatedLoads.put(server, allocateLoad);
                }
            }

            if (availableLoad < allocateLoad || availableLoad < 0) {
                System.out.println("Не удалось распределить всю нагрузку");
            }
        }
        request.setLoad(availableLoad);
    }
}
