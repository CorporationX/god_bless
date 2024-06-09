package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataCenter {
    Map<String,Server> servers = new HashMap<>();
    //Я понимаю, "нужно" лепить private и сеттеры и геттеры, но уж очень код громоздким получается, без модификатора оставлю (default)
    private int totalServers = 0;

    public double countFreeRPS () {
        double freeRPS = 0;
        for (Map.Entry<String, Server> entry : servers.entrySet()) {
            freeRPS = freeRPS + entry.getValue().getMaxLoad() - entry.getValue().getLoad();
        }
        return freeRPS;
    }
    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;
        for (Map.Entry<String, Server> entry : servers.entrySet()) {
            totalEnergy = totalEnergy + entry.getValue().getEnergyConsumption();
        }
        return totalEnergy;
    }
    public double getTotalLoad() {
        double totalLoad = 0;
        for (Map.Entry<String, Server> entry : servers.entrySet()) {
            totalLoad = totalLoad + entry.getValue().getLoad();
        }
        return totalLoad;
    }
    public void addResources(double loadToAdd) {
        for (Map.Entry<String, Server> entry : servers.entrySet()) {
            entry.getValue().setLoad(entry.getValue().getLoad() + loadToAdd / totalServers);
            entry.getValue().setEnergyConsumption(entry.getValue().getEnergyConsumption() + 3*(loadToAdd / totalServers));
        }
    }
    public void removeResources(double loadToRemove) {
        for (Map.Entry<String, Server> entry : servers.entrySet()) {
            entry.getValue().setLoad(entry.getValue().getLoad() - loadToRemove / totalServers);
            entry.getValue().setEnergyConsumption(entry.getValue().getEnergyConsumption() - 3*(loadToRemove / totalServers));
        }
    }
    public void showResources() {
        for (Map.Entry<String, Server> entry : servers.entrySet()) {
            System.out.println("load= " + entry.getValue().getLoad() + " maxLoad= " + entry.getValue().getMaxLoad() + " energy= " + entry.getValue().getEnergyConsumption());
        }
    }
}
