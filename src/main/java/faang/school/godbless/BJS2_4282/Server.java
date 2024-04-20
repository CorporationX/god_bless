package faang.school.godbless.BJS2_4282;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
public class Server {

    private static final Set<Long> ID = new HashSet<>();
    private static final Integer DEFAULT_DOUBLE_LOAD = 40;
    private static final Integer MIN_DOUBLE_LOAD = 0;
    private static final Integer MAX_DOUBLE_LOAD = 100;
    private static final Integer DEFAULT_DOUBLE_ENERGY_CONSUMPTION = 80;
    private static final Integer ELECTRICITY_RATE = 2;

    private Long id;
    private double doubleLoad;
    private double doubleMaxLoad;
    private double doubleEnergyConsumption;

    public Server() {
        this.id = generateId();
        this.doubleLoad = DEFAULT_DOUBLE_LOAD;
        this.doubleMaxLoad = DEFAULT_DOUBLE_LOAD;
        this.doubleEnergyConsumption = DEFAULT_DOUBLE_ENERGY_CONSUMPTION;
    }

    public void setDoubleLoad(int doubleLoad) {
        if (doubleLoad < MIN_DOUBLE_LOAD || doubleLoad > MAX_DOUBLE_LOAD) {
            throw new IllegalArgumentException("Error: not enough resources");
        }
        this.doubleLoad = doubleLoad;
    }

    public void allocateResources(ResourceRequest resourceRequest) {
        double testResource = doubleLoad + resourceRequest.getDoubleLoad();
        if (testResource >= MAX_DOUBLE_LOAD) {
            throw new IllegalArgumentException("Error: not enough resources");
        }
        doubleLoad += resourceRequest.getDoubleLoad();
        if (doubleLoad > doubleMaxLoad) {
            doubleMaxLoad = doubleLoad;
        }
        doubleEnergyConsumption = doubleLoad * ELECTRICITY_RATE;
    }

    public void removeDoubleLoad(ResourceRequest resourceRequest) {
        double testResource = doubleLoad - resourceRequest.getDoubleLoad();
        if (testResource < 0) {
            throw new IllegalArgumentException("Error: not enough resources");
        }
        doubleLoad -= resourceRequest.getDoubleLoad();
        doubleEnergyConsumption = doubleLoad * ELECTRICITY_RATE;
    }

    private Long generateId() {
        Long nextID = ID.isEmpty() ? 1 : Collections.max(ID) + 1;
        ID.add(nextID);
        return nextID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return id.equals(server.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
