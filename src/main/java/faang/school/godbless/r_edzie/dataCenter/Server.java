package faang.school.godbless.r_edzie.dataCenter;

import lombok.Data;

@Data
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
}
