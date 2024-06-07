package faang.school.godbless.datacenter.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Server {

    double load;
    double maxLoad;
    double energyConsumption;

    public Server() {
        this.load = 0.0d;
        this.maxLoad = 10_000.0d;
        this.energyConsumption = 100.0d;
    }

    public void regulateLoad(double load, OptimizationOperation optimizationOperation) {
        switch (optimizationOperation) {
            case INCREASE -> {
                this.load += load;
                this.energyConsumption += load * 0.2;
            }
            case DECREASE ->  {
                this.load -= load;
                this.energyConsumption -= load * 0.2;
            }
        }
    }

    public void scaleVertically(double load) {
        this.maxLoad += load;
    }
}
