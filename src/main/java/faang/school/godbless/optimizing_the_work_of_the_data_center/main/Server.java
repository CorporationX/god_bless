package faang.school.godbless.optimizing_the_work_of_the_data_center.main;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        if (load < 0) {
            throw new IllegalArgumentException("Load cannot be negative");
        }
        if (maxLoad < 0) {
            throw new IllegalArgumentException("Max load cannot be negative");
        }
        if (energyConsumption < 0) {
            throw new IllegalArgumentException("Energy consumption cannot be negative");
        }
        if (load > maxLoad) {
            throw new IllegalArgumentException("Load cannot be greater than max load");
        }
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
}
