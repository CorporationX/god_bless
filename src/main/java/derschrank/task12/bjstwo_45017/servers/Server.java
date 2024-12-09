package derschrank.task12.bjstwo_45017.servers;

import lombok.Getter;

@Getter
public class Server {
    private static final ServersPattern DEFAULT_SERVER_PATTERN = ServersPattern.DEFAULT;

    private boolean on;

    private final String type;
    private final String description;
    private final String name;

    private double load;
    private final double maxLoad;
    private double energyConsumption;
    private final double maxEnergyConsumption;


    public Server(String name) {
        this(name, DEFAULT_SERVER_PATTERN);
    }

    public Server(String name, ServersPattern pattern) {
        this.type = pattern.name();
        this.description = pattern.getName();
        this.name = name;
        this.maxLoad = pattern.getMaxLoad();
        this.maxEnergyConsumption = pattern.getMaxEnergyConsumption();
        switchOn();
    }

    public void switchOn() {
        energyConsumption = maxEnergyConsumption;
        on = true;
    }

    public void switchOff() {
        if (load > 0) {
            System.out.println("Server isn't available to OFF, load is: " + load);
            return;
        }
        energyConsumption = 0;
        on = false;
    }

    public double getAvailableLoad(){
        return maxLoad - load;
    }

    public boolean allocateLoad(double receive) {
        if (receive < 0 || receive > getAvailableLoad()) {
            return false;
        }
        this.load += receive;
        return true;
    }

    public boolean releaseLoad(double realise) {
        if (realise < 0 || realise > load) {
            return false;
        }
        load -= realise;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Server [%s-%s] %s is: %s. Load %.2f / %.2f. Power %.2f / %.2f",
                type, name, description,
                isOn() ? "ON" : "OFF",
                load, maxLoad,
                energyConsumption, maxEnergyConsumption);
    }
}