package data.centre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    private double load;
    public double maxLoad;
    double energyConsumption;


    @Override
    public String toString() {
        return "Load = " + load +
                ", MaxLoad = " + maxLoad;
    }
}
