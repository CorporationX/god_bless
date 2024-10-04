package school.faang.data.center;

public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy strategy;

    public DataCenterService(OptimizationStrategy strategy) {
        this.dataCenter = new DataCenter();
        this.strategy = strategy;
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void deleleServer(Server server) {
        dataCenter.deleteServer(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers()
                .stream()
                .mapToDouble(Server::getEnergyConsumption)
                .sum();
    }

    public void allocateResources(ResourceRequest request) {}

    public void releaseResources(ResourceRequest request) {}
}
