package faang.school.godbless.intro.datacenter.strategy;

import faang.school.godbless.intro.datacenter.model.DataCenter;
import faang.school.godbless.intro.datacenter.model.OptimizationOperation;
import faang.school.godbless.intro.datacenter.model.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Optional;

@Slf4j
public record LoadBalancingOptimizationStrategy() implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        Optional<Server> maxLoadedServer = dataCenter.servers()
                .stream()
                .max(Comparator.comparingDouble(Server::getLoad));
        if (maxLoadedServer.isPresent()) {
            Server newServer = scaleHorizontally(maxLoadedServer.get());
            dataCenter.servers().add(newServer);
        } else {
            log.warn("There appears to be no servers for load balancing");
        }
    }

    private Server scaleHorizontally(Server oldServer) {
        Server newServer = new Server();
        double halfTheLoad = oldServer.getLoad() / 2.0d;
        newServer.regulateLoad(halfTheLoad, OptimizationOperation.INCREASE);
        oldServer.regulateLoad(halfTheLoad, OptimizationOperation.DECREASE);
        return newServer;
    }
}
