package faang.school.godbless.BJS2_19192;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    List<Server> serverList = new ArrayList<>();

    public double getTotalLoad() {
        double total = 0;
        for(var server : serverList) {
            total += server.getLoad();
        }
        return total;
    }

    public double getTotalEnergy() {
        double total = 0;
        for(var server : serverList) {
            total += server.getEnergyConsumption();
        }
        return total;
    }

    public void clearLoad() {
        for(var server : serverList) {
            server.setLoad(0);
        }
    }

    public void clearEnergy() {
        for(var server : serverList) {
            server.setEnergyConsumption(0);
        }
    }

    public double coefficientOfLoadDistribution() {
        if (serverList.isEmpty()) {
            return 0.0;
        }

        double mean = getTotalLoad() / serverList.size();
        double sumSquaredDifferences = 0.0;

        for (var server : serverList) {
            sumSquaredDifferences += Math.pow(server.getLoad() - mean, 2);
        }

        double variance = sumSquaredDifferences / serverList.size();
        double standardDeviation = Math.sqrt(variance);
        double coefficientOfVariation = standardDeviation / mean;

        return 1 - coefficientOfVariation;
    }

    public double coefficientOfEnergyDistribution() {
        if (serverList.isEmpty()) {
            return 0.0;
        }

        double mean = getTotalEnergy() / serverList.size();
        double sumSquaredDifferences = 0.0;

        for (var server : serverList) {
            sumSquaredDifferences += Math.pow(server.getEnergyConsumption() - mean, 2);
        }

        double variance = sumSquaredDifferences / serverList.size();
        double standardDeviation = Math.sqrt(variance);
        double coefficientOfVariation = standardDeviation / mean;

        return 1 - coefficientOfVariation;
    }
}
