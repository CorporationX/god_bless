package faang.school.godbless;

public class DataCenterService {
    public void addServer(DataCenter dataCenter, String name, Server server) {
        dataCenter.servers.put(name, server);
        dataCenter.setTotalServers(dataCenter.getTotalServers() + 1);
    }

    public void removeServer(DataCenter dataCenter, String name) {
        dataCenter.exists(name);
        if (dataCenter.servers.get(name).getLoad() >
                (dataCenter.countFreeRPS() - dataCenter.servers.get(name).getMaxLoad() + dataCenter.servers.get(name).getLoad())) {
            throw new RuntimeException("Not enough free RPS");
        }
        double loadToAdd = dataCenter.servers.get(name).getLoad();
        dataCenter.servers.remove(name);
        dataCenter.setTotalServers(dataCenter.getTotalServers() - 1);
        dataCenter.updateResources(loadToAdd);
    }

    public void allocateResources(DataCenter datacenter, ResourceRequest request) {
        if (request.load() > datacenter.countFreeRPS()) {
            throw new RuntimeException("Not enough free RPS");
        }
        datacenter.updateResources(request.load());
    }

    public void releaseResources(DataCenter datacenter, ResourceRequest request) {
        datacenter.updateResources(-request.load());
    }

    public static void main(String[] args) {
        DataCenterService datacenterService = new DataCenterService();
        DataCenter datacenter = new DataCenter();
        datacenterService.addServer(datacenter, "A", new Server( 0,10000, 4300));
        datacenterService.addServer(datacenter, "B", new Server( 0,8000, 3300));
        datacenterService.addServer(datacenter, "C", new Server( 0,7000, 3000));
        datacenterService.addServer(datacenter, "D", new Server( 0,6000, 2500));
        datacenterService.allocateResources(datacenter, new ResourceRequest(6000));
        datacenter.showResources();
        datacenterService.releaseResources(datacenter, new ResourceRequest(3000));
        datacenterService.removeServer(datacenter, "C");
        datacenter.showResources();
        LoadBalancingOptimizationStrategy strategy = new LoadBalancingOptimizationStrategy();
        strategy.optimize(datacenter);
        datacenter.showResources();
    }

}
