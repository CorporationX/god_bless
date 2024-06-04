package faang.school.godbless.datacenter.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
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
}
