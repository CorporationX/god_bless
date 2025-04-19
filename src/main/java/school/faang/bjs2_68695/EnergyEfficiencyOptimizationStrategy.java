package school.faang.bjs2_68695;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.servers()) {
            if (server.getLoad() == 0.0) {
                server.setEnergyConsumption(0.0); // Отключаем сервер
            }
        }
    }
}
