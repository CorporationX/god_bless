package faang.school.godbless.BJS2_19329;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;


public class DataCenterService {
    DataCenter dataCenter;
    private final double SMALL_SERVER_LOAD;
    private final double MEDIUM_SERVER_LOAD;
    private final double LARGE_SERVER_LOAD;
    private final double ZERO_LOAD = 0.0;

    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.SMALL_SERVER_LOAD = dataCenter.getSMALL_SERVER();
        this.MEDIUM_SERVER_LOAD = dataCenter.getMEDIUM_SERVER();
        this.LARGE_SERVER_LOAD = dataCenter.getLARGE_SERVER();
        this.optimizationStrategy = optimizationStrategy;
    }

    @Setter
    OptimizationStrategy optimizationStrategy;

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServersList().stream()
                .flatMapToDouble(server -> DoubleStream.of(server.getEnergyConsumption()))
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        double requestedLoad = request.getLoad();
        if (requestedLoad > getServersFreeLoad()) {
            System.out.println("Resources not enough, let's add new server");
            Map<Double, Integer> newServers = chooseNewSrvSize(requestedLoad, getServersFreeLoad());
            for (var entry : newServers.entrySet()) {
                if (entry.getValue() != 0) {
                    for (int i = 1; i <= entry.getValue(); i++) {
                        dataCenter.getServersList().add(new Server(entry.getKey()));
                    }
                }
            }
        }
        distributeLoadByServers(requestedLoad);
    }

    private double getServersFreeLoad() {
        double maxServersLoad = dataCenter.getServersList().stream()
                .flatMapToDouble(server -> DoubleStream.of(server.getMaxLoad()))
                .sum();
        return maxServersLoad - getCurrentServersLoad();
    }

    private Map<Double, Integer> chooseNewSrvSize(Double requestedLoad, Double availableLoad) {
        double[] srvSizes = new double[]{SMALL_SERVER_LOAD, MEDIUM_SERVER_LOAD, LARGE_SERVER_LOAD};
        Map<Double, Integer> newServers = new HashMap<>();
        for (double size : srvSizes) {
            newServers.put(size, 0);
        }
        while (requestedLoad > 0) {
            for (double srvSize : srvSizes) {
                if (requestedLoad <= srvSize + availableLoad) {
                    newServers.put(srvSize, newServers.get(srvSize) + 1);
                    requestedLoad = 0.0;
                    break;
                } else if (srvSize == LARGE_SERVER_LOAD) {
                    newServers.put(srvSize, newServers.get(srvSize) + 1);
                    requestedLoad -= srvSize;
                }
            }
        }
        return newServers;
    }

    public void releaseResources(ResourceRequest request) {
        double requestedRemoveLoad = request.getLoad();
        for (Server server : dataCenter.getServersList()) {
            if (requestedRemoveLoad <= 0) {
                break;
            } else if (requestedRemoveLoad >= server.getLoad()) {
                requestedRemoveLoad -= server.getLoad();
                server.setLoad(ZERO_LOAD);
            } else {
                server.setLoad(server.getLoad() - requestedRemoveLoad);
                break;
            }
        }
    }

    private void distributeLoadByServers(double requestedLoad) {
        for (Server server : dataCenter.getServersList()) {
            double srvFreeLoad = server.getMaxLoad() - server.getLoad();
            if (srvFreeLoad >= requestedLoad) {
                server.setLoad(server.getLoad() + requestedLoad);
                break;
            } else {
                server.setLoad(server.getMaxLoad());
                requestedLoad -= srvFreeLoad;
            }
        }
    }

    public double getCurrentServersLoad() {
        return dataCenter.getServersList().stream()
                .flatMapToDouble(server -> DoubleStream.of(server.getLoad()))
                .sum();
    }

    public void printDataCenterConfiguration() {
        for (int i = 0; i < dataCenter.getServersList().size(); i++) {
            System.out.println("Current load  srv#" + i + " Current load : " + dataCenter.getServersList().get(i).getLoad()
                    + ", Max load - " + dataCenter.getServersList().get(i).getMaxLoad() + ", Percent load: " + dataCenter.getServersList().get(i).getPercentLoad()
                    + " Energy consumption - " + dataCenter.getServersList().get(i).getEnergyConsumption());
        }
    }
}


