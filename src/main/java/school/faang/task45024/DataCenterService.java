package school.faang.task45024;

import lombok.Getter;

import java.util.List;

public class DataCenterService implements OptimizationStrategy {
    @Getter
    private final DataCenter dataCenter;
    private final OptimizationStrategy loadBalancingOptimizationStrategy;
    private final OptimizationStrategy energyEfficiencyOptimizationStrategy;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        loadBalancingOptimizationStrategy = new LoadBalancingOptimizationStrategy();
        energyEfficiencyOptimizationStrategy = new EnergyEfficiencyOptimizationStrategy();
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        validationServers(dataCenter.getServers());

        loadBalancingOptimizationStrategy.optimize(dataCenter);
        energyEfficiencyOptimizationStrategy.optimize(dataCenter);

        System.out.println("Optimization complete.");
    }

    private void validationServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("Server is null");
        }
    }

    private void validationResourceRequest(ResourceRequest resourceRequest) {
        if (resourceRequest == null) {
            throw new IllegalArgumentException("ResourceRequest is null");
        }
    }

    private static void validationServers(List<Server> servers) {
        if (servers.isEmpty()) {
            throw new IllegalArgumentException("Server list is empty");
        }
        if (servers.contains(null)) {
            throw new IllegalArgumentException("List contains null");
        }
    }

    public void addServer(Server server) {
        validationServer(server);
        dataCenter.getServers().add(server);
        System.out.println("Server added");
    }

    public void remove(Server server) {
        validationServer(server);
        dataCenter.getServers().remove(server);
        System.out.println("Server removed");
    }

    public double getTotalEnergyConsumption() {
        List<Server> servers = dataCenter.getServers();
        validationServers(servers);

        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public void allocateResources(ResourceRequest request) {
        validationResourceRequest(request);

        List<Server> servers = dataCenter.getServers();

        validationServers(servers);

        double allLoad = servers.stream().mapToDouble(Server::getLoad).sum();

        if (allLoad < request.getLoad()) {
            throw new IllegalArgumentException("All load is less than the requested load");
        }

        double requestLoad = request.getLoad();

        for (Server server : servers) {
            double currentLoad = server.getMaxLoad() - server.getLoad();
            if (currentLoad > 0) {
                double newLoad = Math.min(currentLoad, requestLoad);
                server.setLoad(server.getLoad() + newLoad);
                requestLoad -= newLoad;
            } else {
                System.out.println("Resources have been allocated");
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        validationResourceRequest(request);

        List<Server> servers = dataCenter.getServers();

        validationServers(servers);

        double requestLoad = request.getLoad();

        for (Server server : servers) {
            double currentLoad = server.getLoad();

            if (currentLoad != 0) {
                double releaseLoad = Math.min(currentLoad, requestLoad);
                server.setLoad(currentLoad - releaseLoad);
                requestLoad -= releaseLoad;

                if (requestLoad <= 0) {
                    System.out.println("Resources have been released");
                    break;
                }
            }
        }

        if (requestLoad > 0) {
            System.out.println("Not all the load was released");
        }
    }

}
