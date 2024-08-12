package data.center;

import lombok.Getter;
import lombok.Setter;

public class DataCenterService {
    @Getter
    @Setter
    private OptimizationStrategy strategy;
    private final DataCenter dataCenter;

    public DataCenterService(OptimizationStrategy strategy, DataCenter dataCenter) {
        this.strategy = strategy;
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server) {
        if (this.dataCenter.getServerLoads().containsKey(server)) {
            throw new RuntimeException();
        }

        this.dataCenter.getServerLoads().put(server, server.getMaxLoad());
    }

    public void removeServer(Server server) {
        if (!this.dataCenter.getServerLoads().containsKey(server)) {
            throw new RuntimeException();
        }

        this.dataCenter.getServerLoads().remove(server);
    }

    public void getInfo() {
        System.out.println("Текущая загрузка датацентра: ");
        this.dataCenter.getServerLoads()
                .keySet()
                .forEach(server -> System.out.printf("Загрузка: %s / %s\n", server.getLoad(), server.getMaxLoad()));

        System.out.printf("Потребление: %s\n", this.getTotalEnergyConsumption());
    }

    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;

        for (Server server : this.dataCenter.getServerLoads().keySet()) {
            if (server.getLoad() > 0) {
                totalEnergy += server.getEnergyConsumption();
            }
        }

        return totalEnergy;
    }

    public void allocateResources(ResourceRequest request) {
        for (Server server : this.dataCenter.getServerLoads().keySet()) {
            try {
                server.addRequest(request);
                return;
            } catch (RuntimeException ignored) {}
        }

        throw new RuntimeException("Невозможно разместить: " + request.getLoad());
    }

    public void releaseResources(ResourceRequest request) throws Exception {
        for (Server server : this.dataCenter.getServerLoads().keySet()) {
            server.removeRequest(request);
        }
    }

    public void optimize() {
        this.strategy.optimize(this.dataCenter);
    }
}
