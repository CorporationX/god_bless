package derschrank.sprint01.task12.bjstwo_45017.servers;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Server {
    private static final ServersPattern DEFAULT_SERVER_PATTERN = ServersPattern.DEFAULT;
    private static final boolean DEFAULT_ON_STATUS = false;

    private boolean on;

    private final String type;
    private final String description;
    private final String name;

    @Setter
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

        if (DEFAULT_ON_STATUS) {
            switchOn();
        }
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

    public double getAvailableLoad() {
        return maxLoad - load;
    }

    public boolean allocateLoad(double receive) {
        if (!isOn() || receive < 0 || receive > getAvailableLoad()) {
            return false;
        }
        this.load += receive;
        return true;
    }

    public boolean releaseLoad(double realise) {
        if (!isOn() || realise < 0 || realise > load) {
            return false;
        }
        load -= realise;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Server [%7s-%s] is: %s. Load %6.2f / %.2f. Power %7.2f / %.2f |  %s",
                type, name,
                isOn() ? "ON" : "OFF",
                load, maxLoad,
                energyConsumption, maxEnergyConsumption, description);
    }
}