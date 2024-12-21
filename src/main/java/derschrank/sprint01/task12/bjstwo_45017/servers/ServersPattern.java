package derschrank.sprint01.task12.bjstwo_45017.servers;

import lombok.Getter;

@Getter
public enum ServersPattern {
    DEFAULT("Сервер по умолчанию", 100, 1000),
    BAYKAL("Сервер Baykal", 200, 2000),
    INTEL("Сервер Intel", 300, 2000);


    private final String name;
    private final double maxLoad;
    private final double maxEnergyConsumption;

    ServersPattern(String name, double maxLoad, double maxEnergyConsumption) {
        this.name = name;
        this.maxLoad = maxLoad;
        this.maxEnergyConsumption = maxEnergyConsumption;
    }

}
