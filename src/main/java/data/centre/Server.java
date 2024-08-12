package data.centre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Server {
    private double load;
    public double maxLoad;
    double energyConsumption;

    public Server(double load, double energyConsumption, double maxLoad) {
        this.load = load;
        this.energyConsumption = energyConsumption;
        this.maxLoad = maxLoad;
    }

    @Override
    public String toString() {
        return "Load = " + load +
                ", MaxLoad = " + maxLoad;
    }
}
