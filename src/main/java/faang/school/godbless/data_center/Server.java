package faang.school.godbless.data_center;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Server implements Comparable<Server>{
    private double BASIC_ENERGY_CONSUMPTION = 10;

    private double load;
    private double maxLoad;
    private double energyConsumption;
    private HashMap<Integer, ResourceRequest> requestMap;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
        this.energyConsumption = BASIC_ENERGY_CONSUMPTION;
        requestMap = new HashMap<>();
    }

    @Override
    public int compareTo(Server anotherServer) {
        return (int)(this.load - anotherServer.load);
    }

    public void addRequest(ResourceRequest request){
        if(requestMap.containsKey(request.getId())){
            removeRequest(request);
            addRequest(request);
        } else {
            double requestLoad = request.getLoad();
            if(requestLoad + load > maxLoad){
                throw new RuntimeException("Server is running out of resources that can be provided");
            } else {
                requestMap.put(request.getId(), request);
            }
        }
    }

    public void removeRequest(ResourceRequest request){
        if(requestMap.containsKey(request.getId())){
            double requestLoad = request.getLoad();
            load -= requestLoad;
            requestMap.remove(request.getId());
        }
    }
}
