package faang.school.godbless.Strategy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers;

    public DataCenter(){
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server){
        servers.add(server);
    }
    public void removeServer(Server server){
        servers.remove(server);
    }
    public double getTotalEnergyConsumption() {
        return servers.stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public double getTotalLoad() {
        return servers.stream().mapToDouble(Server::getLoad).sum();
    }

}
