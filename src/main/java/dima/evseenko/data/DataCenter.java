package dima.evseenko.data;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public double getServerLoadByEnergyConsumption(Server server, double energyConsumption) {
        return (energyConsumption * server.getLoad()) / server.getEnergyConsumption();
    }

    public double getServerEnergyConsumptionByServerPercentage(Server server, double percentage) {
        return (getServerLoadByPercentage(server, percentage) * server.getEnergyConsumption()) / server.getLoad();
    }

    public double getServerLoadByPercentage(Server server, double percentage) {
        return (server.getMaxLoad() * percentage) / 100;
    }

    public double getAverageLoadPercentage() {
        return (getTotalLoad() * 100) / getTotalMaxLoad();
    }

    public double getAverageEnergyConsumption() {
        double averageEnergyConsumption = 0;
        for (Server server : servers) {
            averageEnergyConsumption += server.getEnergyConsumption();
        }
        return averageEnergyConsumption / servers.size();
    }

    public double getTotalLoad() {
        double totalLoad = 0;
        for (Server server : this.servers) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public double getTotalMaxLoad() {
        double totalMaxLoad = 0;
        for (Server server : this.servers) {
            totalMaxLoad += server.getMaxLoad();
        }
        return totalMaxLoad;
    }
}
