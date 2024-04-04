package faang.school.godbless.javaHashMap.dataCenter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load; //Текущая нагрузка сервера
    private double maxLoad; //Максимальная нагрузка на сервер, при которой он работает оптимально
    private double energyConsumption;

    public double getAvailableLoad() {
        return maxLoad - load;
    }

    public boolean takeLoad(double newLoad) {
        if (2 * maxLoad - load >= newLoad) {
            load += newLoad;

            return true;
        }
        return false;
    }

    public boolean releaseLoad(double loadToBeReleased) {
        if (load >= loadToBeReleased) {
            load -= loadToBeReleased;

            return true;
        }

        return false;
    }

    public boolean isMaxLoaded() {
        return load > maxLoad;
    }

    public double getExtraLoad() {
        return load - maxLoad;
    }
}
