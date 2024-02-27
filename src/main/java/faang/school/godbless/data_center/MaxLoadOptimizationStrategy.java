package faang.school.godbless.data_center;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxLoadOptimizationStrategy implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        Map<Server, Double> loadMap = new HashMap<>();

        for (Server server : dataCenter.getServerList()) {
            loadMap.put(server, server.getMaxLoad()- server.getLoad());
        }

        Server maxLoadedServer = Collections.min(loadMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        Server minLoadedServer = Collections.max(loadMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        double availableMaxLoadedServer = maxLoadedServer.getMaxLoad()- maxLoadedServer.getLoad();
        double availableMinLoadedServer = minLoadedServer.getMaxLoad()- minLoadedServer.getLoad();

        double equalLoad = (availableMaxLoadedServer +availableMinLoadedServer)/2;
        System.out.println(maxLoadedServer + "   " + minLoadedServer);
        double transferredLoad = equalLoad - availableMaxLoadedServer;
        System.out.println("trasfer:"  + transferredLoad);
        maxLoadedServer.setLoad(maxLoadedServer.getLoad()-transferredLoad);
        minLoadedServer.setLoad(minLoadedServer.getLoad()+transferredLoad);

        System.out.println("Max load optimization strategy applied on server: " + maxLoadedServer);
    }
}
