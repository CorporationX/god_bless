package faang.school.godbless.java.sql.datacenter;

import lombok.Getter;

@Getter
public class Server {
    private static final int MAX_ENERGY_CONSUMPTION = 400;
    private double load; // отражает текущцю нагрузку на сервер
    private double maxLoad; // отражает максимальную нагрузку на сервер
    private double energyConsumption; // отражает текущие энергозатраты сервера.

    public Server(double load, double maxLoad) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = MAX_ENERGY_CONSUMPTION * (load/maxLoad);
    }

    @Override
    public String toString() {
        return String.format("{load=%.2f %%, maxLoad=%.2f %%, consumption=%.2f Wt} %n", this.load, this.maxLoad, this.energyConsumption);
    }

    public void setLoad(double load) {
        this.load = load;
        this.energyConsumption = MAX_ENERGY_CONSUMPTION * (this.load/maxLoad);
    }
}
