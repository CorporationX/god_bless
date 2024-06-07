package faang.school.godbless.OptimizeTheOperationOfDataCenter;

public abstract class DataCenterService {
    OptimizationStrategy optimizationStrategy;

    abstract void addServer(Server server);

    abstract void deleteServer(Server server);
    abstract int getTotalEnergyConsumption();

    abstract void allocateResources(ResourceRequest request);
    abstract void releaseResources(ResourceRequest request);
}
