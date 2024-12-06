package school.faang.sprint_1.task_45027;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter, ResourceRequest request) {
        DataCenterService dataCenterService = new DataCenterService(dataCenter,
                new EnergyEfficiencyOptimizationStrategy());

        double availableLoad = request.getLoad();
        double totalEnergyEfficiency = dataCenterService.getTotalEnergyConsumption();

        for (Server server : dataCenter.servers) {

            double serverEnergyEfficiency = server.getEnergyConsumption();
            double allocateLoad = (serverEnergyEfficiency / totalEnergyEfficiency) * availableLoad;

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
