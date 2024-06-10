package faang.school.godbless.data_center;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@Slf4j
public class Server {
    private double BASIC_ENERGY_CONSUMPTION = 10;

    private int id;
    private double load;
    private double maxLoad;
    private double energyConsumption;
    private Map<Integer, ResourceRequest> requestMap;

    public Server(int id, double maxLoad) {
        this.maxLoad = maxLoad;
        this.energyConsumption = BASIC_ENERGY_CONSUMPTION;
        this.id = id;
        this.requestMap = new HashMap<>();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Server server)) {
            return false;
        }

        return getId() == server.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addRequest(ResourceRequest request) {
        if (requestMap.containsKey(request.getId())) {
            removeRequest(request);
            addRequest(request);
        } else {
            double requestLoad = request.getLoad();
            if (requestLoad + load > maxLoad) {
                throw new RuntimeException("Server is running out of resources that can be provided");
            } else {
                load += requestLoad;
                energyConsumption += requestLoad * 1.2;
                requestMap.put(request.getId(), request);
            }
        }
    }

    public void removeRequest(ResourceRequest request) {
        if (requestMap.containsKey(request.getId())) {
            double requestLoad = request.getLoad();
            load -= requestLoad;
            energyConsumption -= requestLoad * 1.2;
            requestMap.remove(request.getId());
        } else {
            log.warn("Could not find and remove request - {}", request);
        }
    }
}