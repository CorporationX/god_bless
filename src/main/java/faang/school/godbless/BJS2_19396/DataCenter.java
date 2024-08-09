package faang.school.godbless.BJS2_19396;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DataCenter {

    private List<Server> servers;
    private double energyConsumption;
    private double load;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
        this.energyConsumption = servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
        this.load = servers.stream().mapToDouble(Server::getLoad).sum();
    }

    public Server getServer(int index) {
        return servers.get(index);
    }

    public void addServer(Server server) {
        energyConsumption += server.getEnergyConsumption();
        servers.add(server);
    }

    public void removeServer(Server server) {
        energyConsumption -= server.getEnergyConsumption();
        servers.remove(server);
    }

    public int size() {
        return servers.size();
    }

    public List<Server> getServers() {
        return new ArrayList<>(servers);
    }

    public double getArithmeticMeanOfServersLoad() {
        return load / servers.size();
    }
}