package faang.school.godbless.BJS28666;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public boolean tryAllocateResources(ResourceRequest request) {
        if (load + request.getLoad() <= maxLoad) {
            load += request.getLoad();
            request.setLoad(0);
            return true;
        }
        return false;
    }

    public boolean tryReleaseResources(ResourceRequest request) {
        if (load > request.getLoad()) {
            load -= request.getLoad();
            request.setLoad(0);
            return true;
        }
        return false;
    }

    public double getFreeResources() {
        return maxLoad - load;
    }

    public double loadMax() {
        double result = this.getFreeResources();
        load = maxLoad;
        return result;
    }

    public double releaseMax() {
        double result = load;
        load = 0;
        return result;
    }

    public boolean redistributeTo(Server server) {
        if (load < server.getFreeResources()) {
            server.setLoad(server.getLoad() + load);
            load = 0;
            return true;
        }
        load -= server.loadMax();
        return false;
    }
}
