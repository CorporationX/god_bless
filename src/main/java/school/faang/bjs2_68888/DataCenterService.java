package school.faang.bjs2_68888;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataCenterService {
    public static double getTotalEnergyConsumption(DataCenter dataCenter) {
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public static boolean allocateResources(DataCenter dataCenter, ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            double freeCapacity = server.getMaxLoad() - server.getLoad();
            if (freeCapacity == 0) {
                log.info("There is no free capacity in server {}. Switching to the next server.", server);
            } else {
                double toBeAllocated = Math.min(freeCapacity, request.getLoad());
                server.setLoad(server.getLoad() - toBeAllocated);
                request.setLoad(request.getLoad() - toBeAllocated);
            }
        }
        if (request.getLoad() > 0) {
            log.info("Not all resources are allocated. There is no more free capacity left.");
            return Boolean.FALSE;
        } else {
            log.info("All resources have been allocated.");
            return Boolean.TRUE;
        }
    }

    public static void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        for (Server server : dataCenter.getServers()) {
            double resourcesToBeDeallocated = Math.min(server.getLoad(), request.getLoad());
            server.setLoad(server.getLoad() - resourcesToBeDeallocated);
            request.setLoad(request.getLoad() - resourcesToBeDeallocated);
        }
    }

    public static void optimizeLoad(OptimizationStrategy optimizationStrategy, DataCenter dataCenter) {
        if  (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        }
    }
}
