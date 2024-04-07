package faang.school.godbless.sprint_1.optimization_data_center;

import faang.school.godbless.sprint_1.optimization_data_center.dto.ResourceRequest;
import faang.school.godbless.sprint_1.optimization_data_center.optimization.OptimizationStrategy;

import java.util.List;

public class DataCenterService {

    private final DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addNewServerToDataServer(Server server) {
        dataCenter.addServer(server);
    }

    public void deleteServerFromDataCenter(Server server) {
        dataCenter.deleteServer(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getTotalByExpression((result, server2) -> result + server2.getEnergyConsumption());
    }

    public boolean allocateResources(ResourceRequest request) {

        double allocateResources = request.getLoad();
        double availableAllocateResources = dataCenter.getTotalByExpression((result, server) -> result + server.getAvailableLoad());

        if (allocateResources > availableAllocateResources) {
            System.out.println("Resource allocate is not possible");
            return false;
        }

        for (Server server : dataCenter.getServers()) {
            double partOfAllocateResources = server.availableResourcesForAllocate(allocateResources);
            allocateResources -= partOfAllocateResources;
            if (allocateResources == 0) {
                System.out.println("Resource allocate occurred successfully");
                return true;
            }
        }

        return false;
    }

    public boolean releaseResources(ResourceRequest request) {

        double resourcesForRelease = Math.min(
                request.getLoad(),
                dataCenter.getTotalByExpression((result, server) -> result + server.getLoad())
        );

        for (Server server : dataCenter.getServers()) {
            double partOfReleaseResources = server.availableResourcesForRelease(resourcesForRelease);
            resourcesForRelease -= partOfReleaseResources;
            if (resourcesForRelease == 0) {
                break;
            }
        }

        System.out.println("Resource release occurred successfully");
        return true;
    }

    public List<Server> findAllServers() {
        return dataCenter.getServers();
    }

    public void optimize(OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimize(dataCenter);
    }
}