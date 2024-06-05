package BJS2_8541;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public void allocateLoad(double load) {
        this.load += load;
    }

    public void releaseLoad(double load) {
        this.load -= load;
    }
}
