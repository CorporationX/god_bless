package optimizing_the_work_of_the_data_center;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        for (Server server : dataCenter.getServers()) {
            if (server.getLoad() == 0) {
                System.out.println("Server with max load " + server.getMaxLoad() + " is idle, consider shutting it down.");
            }
        }
    }
}

