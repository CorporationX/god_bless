package BJS2_19551;

import lombok.Getter;

import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }

    public void addServer(Server server, DataCenter dataCenter) {
        dataCenter.getServers().add(server);
        System.out.println("Server was added to server list with parameters : ");
        System.out.println(server.getLoad() + " current load");
        System.out.println(server.getMaxLoad() + " maximum load");
        System.out.println(server.getEnergyConsumption() + " energy consumption");
    }

    public void removeServer(Server server, DataCenter dataCenter) {
        dataCenter.getServers().remove(server);
        System.out.println("Server was successfully removed!");
    }

    public double getServersLoad(DataCenter dataCenter) {
        double fullLoad = 0;
        for (Server server : dataCenter.getServers()) {
            fullLoad += server.getLoad();
        }
        return fullLoad;
    }

    public void getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0;

        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        System.out.println("Total energy consumption : " + totalEnergyConsumption + " kwt/h");
    }
}
