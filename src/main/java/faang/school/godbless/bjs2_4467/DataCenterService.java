package faang.school.godbless.bjs2_4467;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class DataCenterService {

    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream()
                .map(Server::getEnergyConsumption)
                .reduce(0.0, Double::sum);
    }

    public void allocateResources(ResourceRequest request) {
        System.out.println("Выделяется ресурс объемом: " + request.getLoad());
    }

    public void releaseResources(ResourceRequest request) {
        System.out.println("Освобождается ресурс объемом: " + request.getLoad());
    }

    public void optimizeDataCenter() {
        optimizationStrategy.optimize(dataCenter);
    }
}
