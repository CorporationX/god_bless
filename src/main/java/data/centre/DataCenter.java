package data.centre;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class DataCenter {

    @Setter
    protected DataCenterService dataCenterService;
    protected Map<Integer, Server> serverIdMap = new HashMap<>();

    public void addServer(Server server) {
        dataCenterService.addService(server);
    }

    public void deleteServer(int id) {
        dataCenterService.deleteServer(id);
    }

    public void hardDeleteServer(int id) {
        dataCenterService.hardDeleteServer(id);
    }

    public double getTotalServerMaxLoad() {
        return dataCenterService.getTotalServerMaxLoad();
    }

    public double getTotalServerLoad() {
        return dataCenterService.getTotalServerLoad();
    }

    public double getTotalServerEnergyConsumption() {
        return dataCenterService.getTotalEnergyConsumption();
    }

    public void printServers() {
        dataCenterService.printServers();
    }

}
