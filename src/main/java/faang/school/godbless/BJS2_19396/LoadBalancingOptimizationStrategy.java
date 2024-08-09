package faang.school.godbless.BJS2_19396;

import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        double arithmeticMeanOfLoad = dataCenter.getArithmeticMeanOfServersLoad();

        for (Server server : servers) {
            if (server.getLoad() > arithmeticMeanOfLoad) {
                double load = server.getLoad() / 2,
                        energyConsumption = server.getEnergyConsumption() / 2,
                        maxEnergyConsumption = server.getMaxEnergyConsumption() / 2;

                server.setLoad(load);
                server.setEnergyConsumption(energyConsumption);
                server.setMaxEnergyConsumption(maxEnergyConsumption);

                Server helpServer = new Server(load, energyConsumption, maxEnergyConsumption);
                dataCenter.addServer(helpServer);
            }
        }
    }
}
