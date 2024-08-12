package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {

    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
        this.load = 0;
        this.energyConsumption = 0;
    }

    public boolean canAllocate(double load) {
        return (this.load + load) <= maxLoad;
    }

    public void allocate(double load) {
        if (canAllocate(load)) {
            this.load += load;
            energyConsumption(load * 0.1);
        } else {
            throw new IllegalStateException("Not enough capacity to allocate load.");
        }
    }

    private void energyConsumption(double amount) {
        energyConsumption += amount;
    }

    public void release(double load) {
        if (this.load >= load) {
            this.load -= load;
        } else {
            throw new IllegalArgumentException("Cannot release more load than allocated.");
        }
    }
}
