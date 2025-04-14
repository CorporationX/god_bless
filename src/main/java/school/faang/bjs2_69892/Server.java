package school.faang.bjs2_69892;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Server {
    private final int id;
    @Setter
    private double load;
    private final double maxLoad;
    @Setter
    private double energyConsumption;

    public Server(int id, double load, double maxLoad, double energyConsumption) {
        this.id = id;
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Server server = (Server) o;
        return this.id == server.getId() && Double.compare(this.maxLoad, server.getMaxLoad()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.maxLoad);
    }
}