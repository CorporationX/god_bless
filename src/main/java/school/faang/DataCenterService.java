package school.faang;

import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DataCenterService implements OptimizationStrategy {
    private final Timer timer = new Timer();
    private static final double EPSILON = 1e-9;

    public void addServer(DataCenter dataCenter, Server server) {
        validateDataCenter(dataCenter);
        dataCenter.servers.add(server);
        System.out.printf("Server %s added to the data center %s \n", server, dataCenter);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        validateDataCenter(dataCenter);
        if (!dataCenter.servers.contains(server)) {
            System.out.printf("There's no server %s in the data center %s\n", server, dataCenter);
            return;
        }
        dataCenter.servers.remove(server);
        System.out.printf("Server %s removed from data center %s\n", server, dataCenter);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        validateDataCenter(dataCenter);
        double energyConsumption = 0;
        for (Server server : dataCenter.servers) {
            energyConsumption += server.getEnergyConsumption();
        }
        return energyConsumption;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        validateDataCenter(dataCenter);
        double allocated = 0;
        for (Server server : dataCenter.servers) {
            double availableLoad = Math.min(request.getLoad() - allocated, server.getMaxLoad() - server.getLoad());
            allocated += availableLoad;
            server.setLoad(server.getLoad() + availableLoad);
            if (allocated == request.getLoad()) {
                return true;
            }
        }
        return false;
    }

    void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        validateDataCenter(dataCenter);
        validateResourceRequest(request);
        double released = 0;
        for (Server server : dataCenter.servers) {
            double loadReduction = Math.min(request.getLoad() - released, server.getLoad());
            released += loadReduction;
            server.setLoad(server.getLoad() + loadReduction);
            if (released == request.getLoad()) {
                System.out.printf("Load from request %s was completely removed\n", request);
                return;
            }
        }
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        validateDataCenter(dataCenter);
        int interval = 30 * 60 * 1000;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.printf("Optimizing the load in the data center %s \n", dataCenter);
                loadBalancingOptimizationStrategy(dataCenter);
            }
        }, 0, interval);
    }

    public void loadBalancingOptimizationStrategy(DataCenter dataCenter) {
        List<Server> servers = dataCenter.servers;
        double meanLoad = 0;
        for (Server server : servers) {
            meanLoad += server.getLoad();
        }
        double totalLoad = meanLoad;
        double distributedLoad = 0;
        meanLoad /= servers.size();

        for (Server server : servers) {
            double canDistribute = Math.min(meanLoad, server.getMaxLoad() - server.getLoad());
            distributedLoad += canDistribute;
            server.setLoad(canDistribute);
        }
        if (totalLoad - distributedLoad > EPSILON) {
            servers.sort(Comparator.comparingDouble(Server::getMaxLoad));
            for (Server server : servers) {
                double canDistribute = Math.min(totalLoad - distributedLoad,
                        server.getMaxLoad() - server.getLoad());
                distributedLoad += canDistribute;
                server.setLoad(canDistribute);
                if (totalLoad - distributedLoad < EPSILON) {
                    break;
                }
            }
        }
    }

    public void energyEfficiencyOptimizationStrategy(DataCenter dataCenter) {
        validateDataCenter(dataCenter);
        List<Server> servers = dataCenter.servers;
        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption));
        distributeLoad(dataCenter, servers);
        servers.sort(Comparator.comparingDouble(Server::getEnergyConsumption).reversed());
        distributeLoad(dataCenter, servers);

        for (Server server : servers) {
            if (server.getLoad() == 0) {
                server.setEnergyConsumption(0.0);
            }
        }
    }

    private void distributeLoad(DataCenter dataCenter, List<Server> servers) {
        for (int first = 0, last = servers.size() - 1; first < last; first++) {
            Server firstServer = servers.get(first);
            if (!canDistributeLoad(dataCenter, first, last)) {
                break;
            }
            for (; firstServer.getLoad() > 0 && first < last; last--) {
                Server lastServer = servers.get(last);
                double take = Math.min(firstServer.getLoad(), lastServer.getMaxLoad() - lastServer.getLoad());
                lastServer.setLoad(lastServer.getLoad() + take);
                firstServer.setLoad(firstServer.getLoad() - take);
            }
        }
    }

    private boolean canDistributeLoad(DataCenter dataCenter, int first, int last) {
        double distributedLoad = 0;
        List<Server> servers = dataCenter.servers;
        for (; first < last; --last) {
            Server lastServer = servers.get(last);
            distributedLoad += lastServer.getMaxLoad() - lastServer.getLoad();
        }
        return distributedLoad >= servers.get(first).getLoad();
    }

    private void validateDataCenter(DataCenter dataCenter) {
        if (dataCenter == null) {
            throw new IllegalArgumentException("The data center can't be null");
        }
    }

    private void validateResourceRequest(ResourceRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("The resource request can't be null");
        }
    }
}