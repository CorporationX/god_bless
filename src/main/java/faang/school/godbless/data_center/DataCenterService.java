package faang.school.godbless.data_center;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class DataCenterService implements OptimizationStrategy {
    public static final int MAX_LOAD = 100;
    public static final int ENERGY_CONSUMPTION = 200;
    private DataCenter dc = new DataCenter();

    public void addServer() {
        // presuming that all servers in dc have the same specs
        //energy consumption per load unit - e.g. on max load server will consume 20000 units of energy
        dc.getServers().add(new Server(0, MAX_LOAD, ENERGY_CONSUMPTION));
        dc.setMaxLoadSum(dc.getMaxLoadSum() + MAX_LOAD);
    }

    public boolean deleteServer() {
        //should be balanced so any server can be removed
        Server serverToDelete = dc.getServers().get(dc.getServers().size() - 1);
        //check if possible
        if (dc.getMaxLoadSum() - serverToDelete.getMaxLoad() - dc.getCurrentLoadSum() < serverToDelete.getLoad()) {
            return false;
        }
        //move resources to other servers
        double share = serverToDelete.getLoad() / (dc.getServers().size() - 1);
        for (int i = 0; i < dc.getServers().size() - 1; i++) {
            dc.getServers().get(i).setLoad(dc.getServers().get(i).getLoad() + share);
        }
        return true;
    }

    public double getTotalEnergyConsumption() {
        return dc.getServers().stream().mapToDouble(s -> s.getEnergyConsumption() * s.getLoad()).sum();
    }

    public boolean allocateResources(ResourceRequest request) {
        //check if possible
        if (dc.getMaxLoadSum() - dc.getCurrentLoadSum() < request.getLoad()) {
            return false;
        }
        //allocate
        double share = request.getLoad() / dc.getServers().size();
        for (int i = 0; i < dc.getServers().size(); i++) {
            dc.getServers().get(i).setLoad(dc.getServers().get(i).getLoad() + share);
        }
        dc.setCurrentLoadSum(dc.getCurrentLoadSum() + request.getLoad());
        return true;
    }

    public void releaseResources(ResourceRequest request) {
        double share = request.getLoad() / dc.getServers().size();
        for (int i = 0; i < dc.getServers().size(); i++) {
            double newLoad = dc.getServers().get(i).getLoad() - share;
            dc.getServers().get(i).setLoad(newLoad < 0 ? 0 : newLoad);
        }
        dc.setCurrentLoadSum(dc.getCurrentLoadSum() - request.getLoad());
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        //not sure what 'optimization' means. here I interpret it as load balancing.
        System.out.println(dataCenter.getServers().size());
        double optimalLoad = dataCenter.getCurrentLoadSum() / dataCenter.getServers().size();
        List<Integer> lowLoad = new ArrayList<>();
        for (int i = 0; i < dataCenter.getServers().size(); i++) {
            if (dataCenter.getServers().get(i).getLoad() < optimalLoad) {
                lowLoad.add(i);
            }
        }
        for (int i = 0; i < dataCenter.getServers().size(); i++) {
            Server from = dataCenter.getServers().get(i);
            double extra = from.getLoad() - optimalLoad;
            int lowLoadPointer = 0;
            while (extra > 0) {
                Server to = dataCenter.getServers().get(lowLoad.get(lowLoadPointer));
                double canAdd = Math.min(optimalLoad - to.getLoad(), extra);
                from.setLoad(from.getLoad() - canAdd);
                to.setLoad(to.getLoad() + canAdd);
                extra -= canAdd;
                lowLoadPointer++;
            }
        }

    }
}
