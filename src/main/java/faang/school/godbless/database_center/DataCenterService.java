package faang.school.godbless.database_center;

import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class DataCenterService {
    private DataCenter dataCenter;

    public void addDataCenter(Server server) {
        dataCenter.getListOfServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getListOfServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getListOfServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public List<Server> getInfoServers() {
        return dataCenter.getListOfServers();
    }

    public void allocateResources(ResourceRequest request) {
        if (checkFreeServer(request)) {
            System.out.println("Request load: " + request.getLoad()+ " is done.");
        } else if (checkAvailableResources() >= request.getLoad()){
            distributeRequestLoad(request);
        }else {
            releaseResources(request);
            allocateResources(request);
        }
    }

    private void distributeRequestLoad(ResourceRequest request) { //распределение ресурсов
        double requestLoad = request.getLoad();
        for (Server server : dataCenter.getListOfServers()) {
            double temp = Math.abs(server.getMaxLoad() - server.getLoad());
            server.setLoad(server.getLoad() + temp);
            requestLoad -= temp;

            if (requestLoad <= 0) {
                System.out.println("Request load has been distributed.");
                break;
            }
        }
    }

    private double checkAvailableResources() {
        double availableResources = 0.0;
        for (Server server : dataCenter.getListOfServers()) {
            availableResources += server.getMaxLoad() - server.getLoad();
        }
        System.out.println("Available resourcse: " + availableResources);
        return availableResources;
    }

    private boolean checkFreeServer(ResourceRequest request) {
        boolean isServer = false;
        double requestLoad = request.getLoad();
        for (Server server : dataCenter.getListOfServers()) {
            if (server.getMaxLoad() >= server.getLoad() + requestLoad) {
                server.setLoad(server.getLoad() + requestLoad);
                isServer = true;
                break;
            }
        }
        return isServer;
    }

    public void releaseResources(ResourceRequest request) {
        double loadResources = request.getLoad();

        Server maxLoadServer = dataCenter.getListOfServers().get(0);
        double maxLoad = maxLoadServer.getLoad();

        for (Server server : dataCenter.getListOfServers()) {
            if (server.getLoad() > maxLoad) {
                maxLoadServer = server;
                maxLoad = server.getLoad();
            }
        }

        double newLoad = maxLoadServer.getLoad() - loadResources;
        if (newLoad < 0) {
            newLoad = 0;
        }
        maxLoadServer.setLoad(newLoad);
    }
}
