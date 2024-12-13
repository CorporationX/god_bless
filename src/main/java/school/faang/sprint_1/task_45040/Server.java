package school.faang.sprint_1.task_45040;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Server {
    @Setter
    private double load;
    private final double maxLoad;
    private final double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
        this.load = 0;
    }

    public void addLoad(double additionalLoad) {
        if (load + additionalLoad <= maxLoad) {
            load += additionalLoad;
        } else {
            throw new IllegalArgumentException("Перегрузка сервера");
        }
    }

    public void removeLoad(double removedLoad) {
        if (load - removedLoad >= 0) {
            load -= removedLoad;
        } else {
            throw new IllegalArgumentException("Недостаточная нагрузка для удаления");
        }
    }
}
