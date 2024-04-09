package BJS2_5010;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public void allocateResources(ResourceRequest request) {
        var server = dataCenter.findLowLoadServer(request);
        if (server != null) {
            server.setLoad(request.getLoad() + server.getLoad());
        } else {
            System.out.println("All server is busy");
        }
    }

    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() == server.getMaxLoad()) {
                if (server.getMaxLoad() < request.getLoad()) {
                    server.setLoad(server.getLoad() - request.getLoad());
                    request.setLoad(Math.abs(server.getLoad()));
                    server.setLoad(0);
                } else {
                    server.setLoad(server.getLoad() - request.getLoad());
                    break;
                }
            }
        }
    }

    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
