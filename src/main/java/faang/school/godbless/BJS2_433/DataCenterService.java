package faang.school.godbless.BJS2_433;

import faang.school.godbless.BJS2_433.optimization.BraindeadOptimizationStrategyImpl;
import faang.school.godbless.temp.DataCenter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class DataCenterService{

    private final DataCenter dataCenter = DataCenter.getInstance();


    public void addServer (Server server) {
        dataCenter.add(server);
    }

    public double getTotalEnergyConsumption () {
        double total = 0;
        for (Server x : dataCenter.getServerList()) {
            total += x.getEnergyConsumption();
        }
        return total;
    }

    public void optimizeEveryRequestedMinutes (int minutes) {
        BraindeadOptimizationStrategyImpl braindeadOptimizationStrategy = new BraindeadOptimizationStrategyImpl();

        /////

    }


    public boolean allocateResources(ResourceRequest request) {


        return true;
    }

    public boolean releaseResources(ResourceRequest request) {



        return true;
    }

}
