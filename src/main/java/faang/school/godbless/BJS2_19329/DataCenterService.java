package faang.school.godbless.BJS2_19329;

import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
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

    private void allocateResources(ResourceRequest request) {
        if (request.getLoad() >= getServersFreeLoad()) {
            System.out.println("Resources not enough, let's add new server");
            if (request.getLoad()<=SMALL_SERVER_LOAD) {
                dataCenter.getServersList().add(new Server(SMALL_SERVER_LOAD,100,500));
            }
        }
        System.out.println("You can use current configuration of DataCenter");


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
