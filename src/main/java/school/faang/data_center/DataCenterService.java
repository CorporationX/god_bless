package school.faang.data_center;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import school.faang.util.ParameterUtil;

@RequiredArgsConstructor
public class DataCenterService {
    private final OptimizationStrategy strategy;

    public boolean addServer(DataCenter dataCenter, Server server) {
        return dataCenter.addServer(server);
    }

    public boolean removeSever(DataCenter dataCenter, Server server) {
        return dataCenter.removeServer(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        ParameterUtil.checkToNull(dataCenter, "dataCenter");

        double total = 0;
        for (Server server : dataCenter.getServerList()) {
            total += server.getEnergyConsumption();
        }

        return total;
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        ParameterUtil.checkToNull(dataCenter, "dataCenter");
        ParameterUtil.checkToNull(request, "request");

        double remainingLoad = request.getLoad();
        if (getAvailableCapacity(dataCenter) < remainingLoad) {
            return false;
        }

        for (Server server : dataCenter.getServerList()) {
            double availableLoad = server.getMaxLoad() - server.getLoad();
            if (remainingLoad > 0) {
                double load = Math.min(availableLoad, remainingLoad);
                server.setLoad(server.getLoad() + load);
                remainingLoad -= load;
            }

            if (remainingLoad <= 0) {
                break;
            }
        }

        return true;
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        ParameterUtil.checkToNull(dataCenter, "dataCenter");
        ParameterUtil.checkToNull(request, "request");
        double loadToRelease = request.getLoad();
        for (Server server : dataCenter.getServerList()) {
            double load = Math.min(server.getLoad(), loadToRelease);
            server.setLoad(server.getLoad() - load);
            loadToRelease = loadToRelease - load;

            if (loadToRelease <= 0) {
                return;
            }
        }
    }

    public void optimize(DataCenter dataCenter) {
        ParameterUtil.checkToNull(dataCenter, "dataCenter");
        strategy.optimize(dataCenter);
    }

    private double getAvailableCapacity(DataCenter dataCenter) {
        Double availableCapacity = 0.0;
        for (Server server : dataCenter.getServerList()) {
            availableCapacity += server.getMaxLoad() - server.getLoad();
        }

        return availableCapacity;
    }
}
