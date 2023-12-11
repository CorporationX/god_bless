package faang.school.godbless.BJS2_433;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Server {
    private final static double kw = 3.0;
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public double getEnergyConsumption() {
        return (load * kw) * load / maxLoad;
    }
}