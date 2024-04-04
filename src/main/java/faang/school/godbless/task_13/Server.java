package faang.school.godbless.task_13;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
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
