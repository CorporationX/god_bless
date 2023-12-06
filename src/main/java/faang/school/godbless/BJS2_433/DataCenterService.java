package faang.school.godbless.BJS2_433;

import faang.school.godbless.BJS2_433.optimization.BraindeadOptimizationStrategyImpl;
import faang.school.godbless.BJS2_433.optimization.OptimizationStrategy;
import faang.school.godbless.temp.DataCenter;
import lombok.Data;

@Data
public class DataCenterService{

    private final DataCenter dataCenter = DataCenter.getInstance();
    private final OptimizationStrategy strategy = new BraindeadOptimizationStrategyImpl();


    public void addServer (Server server) {
        dataCenter.add(server);
    }

    public double getTotalEnergyConsumption () {
        double total = 0;
        for (Server server : dataCenter.getServerList()) {
            total += server.getEnergyConsumption();
        }
        return total;
    }

    public void optimizeEveryRequestedMinutes (int minutes) {

        strategy.optimize(this.dataCenter);
        /////

    }


    public boolean allocateResources(ResourceRequest request) {



        return false;
    }

    public boolean releaseResources(ResourceRequest request) {



        return true;
    }

}
