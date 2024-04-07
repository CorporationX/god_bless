package faang.school.godbless.bjs2_4467;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

@Slf4j
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
        log.info("Remove server from Data center");
        if (!dataCenter.getServers().remove(server)) {
            log.warn("Server not found in data center");
            throw new NoSuchElementException("Server not found in data center");
        }
    }

    public double getTotalEnergyConsumption() {
        log.info("Get energy consumption");
        double consumption =  dataCenter.getServers().stream()
                .map(Server::getEnergyConsumption)
                .reduce(0.0, Double::sum);
        log.info("Total consumption: " + consumption);
        return consumption;
    }

    public void allocateResources(ResourceRequest request) {
        log.info("Выделяется ресурс объемом: " + request.getLoad());
    }

    public void releaseResources(ResourceRequest request) {
        log.info("Освобождается ресурс объемом: " + request.getLoad());
    }

    public void optimizeDataCenter() {
        optimizationStrategy.optimize(dataCenter);
    }
}
