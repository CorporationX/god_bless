package faang.school.godbless.datacenter;

import lombok.Getter;

@Getter
public class Server {
    double load;
    double maxLoad;
    double energyConsumption;

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
