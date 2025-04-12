package school.faang.data_center;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = 0;
        for (Server server : dataCenter.getServers()) {
            totalLoad += server.getLoad();
        }

        double averageLoad = totalLoad / dataCenter.getServers().size();

        int setLoadFailed = 0;
        for (Server server : dataCenter.getServers()) {
            if (averageLoad <= server.getMaxLoad()) {
                server.setLoad(averageLoad);
            } else {
                server.setLoad(server.getMaxLoad());
                setLoadFailed++;
                log.info("Maximum server load ({}) is less then ({})," +
                        " maximum possible load was set", server.getMaxLoad(), averageLoad);
            }
        }
        log.info("Even load distribution for servers was finished. " +
                "Amount of servers with maximum load less then average: {}", setLoadFailed);
    }
}
