package school.faang.bjs245016.optimizationstrategies;

import school.faang.bjs245016.DataCenter;
import school.faang.bjs245016.OptimizationStrategy;
import school.faang.bjs245016.Server;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter datacenter) {
        System.out.println("Energy efficient optimization flow");

        datacenter.getServersList().forEach(server -> server.setLoad(
                datacenter.getServersList().stream()
                        .mapToDouble(Server::getLoad)
                        .average()
                        .orElse(0.0)));
    }
}

