package faang.school.godbless.optimization_data_center;

import faang.school.godbless.optimization_data_center.dto.ResourceRequest;
import faang.school.godbless.optimization_data_center.optimization.OptimizationStrategy;

import java.util.List;

public class DataCenterService {

    /*
      Не очень мне нравится что в DataCenterService у меня только один DataCenter,
      наверно лучше убрать его отсюда и передавать в параметры методов.
    */
    private final DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addNewServerToDataServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void deleteServerFromDataCenter(Server server) {
        for (int i = 0; i < dataCenter.getServers().size(); i++) {
            if (dataCenter.getServers().get(i).equals(server)) {
                dataCenter.getServers().remove(i);
                break;
            }
        }
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .reduce(0.0, (result, server2) -> result + server2.getEnergyConsumption(), Double::sum);
    }

    public boolean allocateResources(ResourceRequest request) {

        double allocateResources = request.getLoad();

        double availableAllocateResources = dataCenter.getServers().stream()
                .reduce(0.0, (result, server) -> result + server.getAvailableLoad(), Double::sum);

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

        double releaseResources = request.getLoad();

        double availableReleaseResources = dataCenter.getServers().stream()
                .reduce(0.0, (result, server) -> result + server.getLoad(), Double::sum);

        if (releaseResources > availableReleaseResources) {
            System.out.println("Resource release is not possible");
            return false;
        }

        for (Server server : dataCenter.getServers()) {
            double partOfAllocateResources = server.availableResourcesForRelease(releaseResources);
            releaseResources -= partOfAllocateResources;
            if (releaseResources == 0) {
                System.out.println("Resource release occurred successfully");
                return true;
            }
        }

        return false;
    }

    public List<Server> findAllServers() {
        return dataCenter.getServers();
    }

    public void optimize(OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimization(dataCenter);
    }

}
