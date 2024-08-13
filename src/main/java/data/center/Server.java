package data.center;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Server {
    private double load = 0;
    private final double maxLoad;
    private final double energyConsumption;
    private final Map<ResourceRequest, Double> requestsLoad = new HashMap<>();

    public Server(double maxLoad, double energyConsumption) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
    public void addRequest(ResourceRequest request) {
        if (this.getAvailableLoad() >= request.getLoad()) {
            this.load += request.getLoad();
            this.requestsLoad.put(request, request.getLoad());

            return;
        }

        throw new RuntimeException();
    }

    public void removeRequest(ResourceRequest request) {
        if (this.requestsLoad.containsKey(request)) {
            this.load -= request.getLoad();
            this.requestsLoad.remove(request);
        }
    }

    public double getAvailableLoad() {
        return this.maxLoad - this.load;
    }

    public double loadPercent() {
        return this.getLoad() / this.getMaxLoad() * 100;
    }
}
