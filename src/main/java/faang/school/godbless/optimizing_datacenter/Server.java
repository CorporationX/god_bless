package faang.school.godbless.optimizing_datacenter;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Server {
    private double load = 0.0;
    private double maxLoad;
    private double energyConsumption = 1.0;
    List<ResourceRequest> requests = new ArrayList<>();

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public void executeRequest(ResourceRequest request){
        if(requests.contains(request)){ throw new IllegalArgumentException("Request already executed");}
        load += request.getLoad();
        requests.add(request);
        energyConsumption = Math.pow(2, load);
    }

    public void releaseRequest(ResourceRequest request) {
        if(!requests.contains(request)){ throw new IllegalArgumentException("Request not executed on this resource"); }
        load -= request.getLoad();
        requests.remove(request);
        energyConsumption = Math.pow(2, load);
    }
}
