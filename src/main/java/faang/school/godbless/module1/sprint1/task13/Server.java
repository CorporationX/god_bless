package faang.school.godbless.module1.sprint1.task13;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server() {
        this.load = 10;
        this.maxLoad = 100;
        this.energyConsumption = 20;
    }
}
