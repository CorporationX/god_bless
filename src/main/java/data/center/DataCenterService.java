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
        this.dataCenter.getServers().add(server);
    }

    public void getInfo() {
        System.out.println("Текущая загрузка датацентра: ");
        this.dataCenter.getServers().forEach(server -> System.out.printf("Загрузка: %s / %s\n", server.getLoad(), server.getMaxLoad()));

        System.out.printf("Стоимость размещения ресурсов: %s\n", this.dataCenter.calculateCost());
        System.out.printf("Потребление: %s\n", this.getTotalEnergyConsumption());
    }

    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;

        for (Server server : this.dataCenter.getServers()) {
            totalEnergy += server.getCurrentEnergyConsumption();
        }

        return totalEnergy;
    }

    public void allocateResources(ResourceRequest request) throws Exception {
        if (!this.dataCenter.allocateResources(request)) {
            throw new Exception("Невозможно разместить: " + request.getLoad());
        }
    }

    public void releaseResources(ResourceRequest request) throws Exception {
        if (!this.dataCenter.releaseResources(request)) {
            throw new Exception(String.format("Ранее ресурс: %s не размещался. ", request.getLoad()));
        }
    }

    public void optimize() throws Exception {
        this.strategy.optimize(this.dataCenter);
    }
}
