package faang.school.godbless.java.sql.datacenter;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class DataCenterService {

    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void allocateResources(ResourceRequest request) {
        this.optimizationStrategy.optimize(this.dataCenter);

        double remainingLoad = request.getLoad();

        for (Server server: this.dataCenter.getServers()) {
            if (remainingLoad <= 0) {
                break;
            }

            double availableCapacity = server.getMaxLoad() - server.getLoad();

            if (availableCapacity >= remainingLoad) {
                server.setLoad(server.getLoad() + remainingLoad);
                remainingLoad = 0;
            } else {
                server.setLoad(server.getLoad() + availableCapacity);
                remainingLoad -= availableCapacity;
            }
        }

        if (remainingLoad > 0) {
            System.out.println("Not enough capacity in datacenter to handle the full load.");
        }
    }

    public void releaseResources(ResourceRequest request) {
        this.optimizationStrategy.optimize(this.dataCenter);
        double remainingLoad = request.getLoad();
        for (int i = this.dataCenter.getServers().size() - 1; i >= 0; i--) {
            double busyResource = this.dataCenter.getServers().get(i).getLoad();
            if (busyResource == 0) {
                System.out.println("Nothing to released");
                break;
            }
            if (busyResource >= remainingLoad) {
                this.dataCenter.getServers().get(i).setLoad(busyResource - remainingLoad);
                remainingLoad = 0;
            } else {
                this.dataCenter.getServers().get(i).setLoad(0);
                remainingLoad -= busyResource;
            }
        }

        if (remainingLoad > 0) {
            System.out.println("All resources in datacenter have been released");
        }
    }

    public void addNewServerToDataCenter(Server server) {
        this.dataCenter.addNewServer(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0;
        for (Server server: this.dataCenter.getServers()) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

}
