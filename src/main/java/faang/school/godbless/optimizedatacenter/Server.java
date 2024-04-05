package faang.school.godbless.optimizedatacenter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public double getAvailableLoad() {
        return maxLoad - load;
    }

    public void setLoad(double load) {
        this.load = load;
        this.energyConsumption = load * 1.5;
    }
}
