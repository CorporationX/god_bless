package faang.school.godbless.datacenter.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Server {

    private double load;
    private double maxLoad = 100;
    private double energyConsumption = 10;

    public Server(double load) {

        if (load > this.maxLoad) {
            throw new IllegalArgumentException("load is more than max load");
        } else if (load < 0) {
            throw new IllegalArgumentException("load can't be 0");
        }

        this.load = load;
        this.energyConsumption = this.getEnergyConsumption() + load;
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
