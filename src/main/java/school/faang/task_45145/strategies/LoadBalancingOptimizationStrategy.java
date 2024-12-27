package school.faang.task_45145.strategies;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45145.models.DataCenter;
import school.faang.task_45145.models.Server;

import java.util.Set;

@Slf4j
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        log.info("Starting load balancing optimization strategy for Data Center '{}'", dataCenter.getName());
        Set<Server> servers = dataCenter.getServers();
        double totalLoad = 0;

        for (Server server : servers) {
            totalLoad += server.getLoad();
            log.debug("Server '{}' current load: {}", server.getName(), server.getLoad());
        }

        double averageLoad = totalLoad / servers.size();
        log.info("Calculated average load: {}", averageLoad);

        for (Server server : servers) {
            server.setLoad(averageLoad);
            log.debug("Server '{}' updated load: {}", server.getName(), server.getLoad());
        }

        log.info("Load balancing optimization strategy completed for Data Center '{}'", dataCenter.getName());
    }
}
