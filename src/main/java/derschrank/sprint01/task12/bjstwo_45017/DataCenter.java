package derschrank.sprint01.task12.bjstwo_45017;

import derschrank.sprint01.task12.bjstwo_45017.servers.Server;

import java.util.HashSet;
import java.util.Set;

public class DataCenter {
    private Set<Server> servers;

    public DataCenter() {
        this(new HashSet<>());
    }

    public DataCenter(Set<Server> servers) {
        this.servers = servers;
    }


    public Set<Server> getServers() {
        return servers;
    }


    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server : this.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getTotalMaxEnergyConsumption() {
        double totalMaxEnergyConsumption = 0;
        for (Server server : this.getServers()) {
            totalMaxEnergyConsumption += server.getMaxEnergyConsumption();
        }
        return totalMaxEnergyConsumption;
    }


    public double getTotalAvailableLoad() {
        double totalAvailableLoad = 0;
        for (Server server : this.getServers()) {
            totalAvailableLoad += server.getAvailableLoad();
        }
        return totalAvailableLoad;
    }

    public double getTotalMaxLoad() {
        double totalMaxLoad = 0;
        for (Server server : this.getServers()) {
            totalMaxLoad += server.getMaxLoad();
        }
        return totalMaxLoad;
    }

    public double getTotalLoad() {
        double totalLoad = 0;
        for (Server server : this.getServers()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public void stopAndSwitchOffAllServers() {
        for (Server server : this.getServers()) {
            server.setLoad(0);
            server.switchOff();
        }
    }

    public void switchOnAllServers() {
        for (Server server : this.getServers()) {
            server.switchOn();
        }
    }

    public void resetAllServers() {
        stopAndSwitchOffAllServers();
        switchOnAllServers();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Server server : servers) {
            result.append(server);
            result.append("\n");
        }

        result.append("\nTotalLoad Current / Available / Max: ");
        result.append(getTotalLoad());
        result.append(" / ");
        result.append(getTotalAvailableLoad());
        result.append(" / ");
        result.append(getTotalMaxLoad());

        result.append("\nTotalEnergyConsumption Current / Max: ");
        result.append(getTotalEnergyConsumption());
        result.append(" / ");
        result.append(getTotalMaxEnergyConsumption());

        return result.toString();
    }
}
