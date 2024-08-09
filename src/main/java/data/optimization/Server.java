package data.optimization;

import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Data
public class Server {
    private final double maxLoad;
    private final double efficiencyConsumption;
    private final Map<ResourceRequest, Double> requestsLoad = new HashMap<>();
    private double load = 0;
    private double energyConsumption;

    public void addRequest(@NonNull ResourceRequest request) {
        if (getAvailableLoad() >= request.getLoad()) {
            load += request.getLoad();
            requestsLoad.put(request, request.getLoad());
            energyConsumption = load / maxLoad * efficiencyConsumption;
            System.out.println("\nRequest added");
        } else {
            System.out.println("\nNot enough available load on this server");
        }
    }

    public void removeRequest(@NonNull ResourceRequest request) {
        if (requestsLoad.containsKey(request)) {
            load -= request.getLoad();
            requestsLoad.remove(request);
            energyConsumption = load / maxLoad * efficiencyConsumption;
            System.out.println("\nRequest removed");
        } else {
            System.out.println("\nNo such request on this server");
        }
    }

    public double getAvailableLoad() {
        return maxLoad - load;
    }
}
