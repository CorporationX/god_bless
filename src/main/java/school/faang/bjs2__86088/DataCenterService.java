package school.faang.bjs2__86088;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DataCenterService {
    private OptimizationStrategy optimizationStrategy;

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.addServerInList(server);
    }

    public void removeSever(DataCenter dataCenter, Server server) {
        List<Server> listServer = dataCenter.getListServer();
        listServer.remove(server);
        dataCenter.setListServer(listServer);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {

        return dataCenter.getListServer().stream()
                .mapToDouble(d -> d.getEnergyConsumption())
                .sum();
    }

    public boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double load = request.getLoad();
        List<Server> listServer = dataCenter.getListServer();
        int countServer = listServer.size();
        double loadOneServer = load / countServer;

        for (int i = 0; i < listServer.size(); i++) {
            double currentLoad = listServer.get(i).getLoad() + loadOneServer;
            if (currentLoad > listServer.get(i).getMaxLoad()) {
                double loadRemainder = currentLoad - listServer.get(i).getMaxLoad();
                currentLoad = currentLoad - loadRemainder;
                loadOneServer = load + loadRemainder / countServer;
            }
            listServer.get(i).setLoad(currentLoad);
        }
        return true;
    }

    public void optimizeLoad(DataCenter dataCenter, ResourceRequest request) {
        optimizationStrategy.optimize(dataCenter, request.getLoad());
    }

    public void releaseResource(DataCenter dataCenter, ResourceRequest request) {
        double loadRelease = request.getLoad();
        for (Server server : dataCenter.getListServer()) {
            double loadReduction = Math.min(server.getLoad(), loadRelease);
            server.setLoad(server.getLoad() - loadReduction);
            loadRelease -= loadReduction;
            if (loadRelease <= 0) {
                return;
            }
        }
    }

}
