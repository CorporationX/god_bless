package faang.school.godbless.datacenter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public void increaseLoad(double amount) {
        if (load + amount <= maxLoad) {
            load += amount;
        } else {
            throw new IllegalArgumentException("Load exceeds maximum limit");
        }
    }

    public void decreaseLoad(double amount) {
        if (load - amount >= 0) {
            load -= amount;
        } else {
            throw new IllegalArgumentException("Load cannot be negative");
        }
    }
}
