package faang.school.godbless.optTask.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class DataCenter {
    private List<Server> servers;

synchronized
    public List<Server> getServers() {
        return servers;
    }

    public double getTotalEnergyConsumption() {
        double sum = 0;
        for (Server server: servers){
            if (server.getLoad()>0){
                sum+=server.getEnergyConsumption();
            }
        }
        return sum;
    }
    public double getTotalLoad() {
        double sum = 0;
        for (Server server: servers){
            sum+=server.getLoad();
        }
        return sum;
    }

    public double getTotalMaxLoad() {
        double sum = 0;
        for (Server server: servers){
            sum+=server.getMaxLoad();
        }
        return sum;
    }
}
