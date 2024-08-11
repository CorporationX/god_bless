package faang.school.godbless.BJS2_19192;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalEnergy = dataCenter.getTotalEnergy();
        dataCenter.clearEnergy();
        double avg = totalEnergy / dataCenter.getServerList().size();

        for (var server : dataCenter.getServerList()) {
            server.setEnergyConsumption(avg);
        }
    }
}
