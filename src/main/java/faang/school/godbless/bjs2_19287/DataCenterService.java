package faang.school.godbless.bjs2_19287;

public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(OptimizationStrategy optimizationStrategy) {
        this.dataCenter = DataCenter.getInstance();
        this.optimizationStrategy = optimizationStrategy;
    }

    public void addServer() {
        dataCenter.addServer();
    }

    public void addServerAndTurnOn() {
        dataCenter.addServerAndTurnOn();
    }

    public void printState() {
        dataCenter.printState();
    }

    public void allocateResources(ResourceRequest request) {
        dataCenter.allocateLoad(request.getLoad());
    }

    public void releaseResources(ResourceRequest request) {
        dataCenter.releaseLoad(request.getLoad());
    }

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }

    public void printNotActiveServers() {
        dataCenter.printInactiveServersData();
    }
}
