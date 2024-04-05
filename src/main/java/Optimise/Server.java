package Optimise;

import java.util.Objects;

public class Server {
    private double load; //— отражает текущую нагрузку на сервер
    private double maxLoad; // — отражает максимальную нагрузку на сервер
    private double energyConsumption; // — отражает текущие энергозатраты сервера

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public double energyConsumption() {
        return energyConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return Double.compare(load, server.load) == 0 && Double.compare(maxLoad, server.maxLoad) == 0 && Double.compare(energyConsumption, server.energyConsumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(load, maxLoad, energyConsumption);
    }
}
