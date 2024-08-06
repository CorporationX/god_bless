package faang.school.godbless.BJS2_19329;

import lombok.AllArgsConstructor;

import java.util.stream.DoubleStream;

@AllArgsConstructor
public class DataCenterService implements OptimizationStrategy {
    private final double SMALL_SERVER_LOAD = 100;
    private final double MEDIUM_SERVER_LOAD = 150;
    private final double LARGE_SERVER_LOAD = 200;
    DataCenter dataCenter;

    private double getTotalEnergyConsumption() {
        return dataCenter.getServersList().stream()
                .flatMapToDouble(server -> DoubleStream.of(server.getEnergyComsumption()))
                .sum();
    }

    public void allocateResources(ResourceRequest request) {
        double requestedLoad = request.getLoad();
        if (requestedLoad >= getServersFreeLoad()) {
            System.out.println("Resources not enough, let's add new server");
            if (requestedLoad <= SMALL_SERVER_LOAD) {
                dataCenter.getServersList().add(new Server(requestedLoad, SMALL_SERVER_LOAD));
            }
        }
        System.out.println("You can use current configuration of DataCenter " +
                "no need to add new server");
        distributeLoadByServers(requestedLoad) ;
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

    private void releaseResources(ResourceRequest request) {

    }

    private double getCurrentServersLoad() {
        return dataCenter.getServersList().stream()
                .flatMapToDouble(server -> DoubleStream.of(server.getLoad()))
                .sum();
    }

    private double getServersFreeLoad() {
        double maxServersLoad = dataCenter.getServersList().stream()
                .flatMapToDouble(server -> DoubleStream.of(server.getMaxLoad()))
                .sum();
        return maxServersLoad - getCurrentServersLoad();
    }

    public void printDataCenterConfiguration() {
        for (int i = 0; i < dataCenter.getServersList().size(); i++) {
            System.out.println("Загрузка сервера #" + i + ": " + dataCenter.getServersList().get(i).getLoad());
        }
    }

    @Override
    public void optimize(DataCenter dataCenter) {

    }

    @Override
    public void LoadBalancingOptimizationStrategy(DataCenter dataCenter) {

    }

    @Override
    public void EnergyEfficencyOptimizationStrategy(DataCenter dataCenter) {

    }
}
