package ru.kraiush.BJS2_33156;

import lombok.Data;

@Data
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.load = 0.0;
        this.maxLoad = maxLoad;
        this.energyConsumption = 0.0;
    }

    public void allocateLoad(double load) {
        this.load += load;
        updateEnergyConsumption();
    }


    public void releaseLoad(double load) {
        this.load -= load;
        updateEnergyConsumption();
    }

    private void updateEnergyConsumption() {
        this.energyConsumption = load * 2;
    }
}
