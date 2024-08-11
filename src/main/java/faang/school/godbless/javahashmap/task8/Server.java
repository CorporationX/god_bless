package faang.school.godbless.javahashmap.task8;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Server {
    private double load;

    public void setLoad(double load) {
        if (load <= maxLoad) {
            this.load = load;
        }
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    private double maxLoad;
    private double energyConsumption;
}
