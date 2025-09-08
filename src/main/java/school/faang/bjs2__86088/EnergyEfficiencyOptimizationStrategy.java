package school.faang.bjs2__86088;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EnergyEfficiencyOptimizationStrategy implements OptimizationStrategy {
    public static final double ZERO_LOAD = 0;

    @Override
    public void optimize(DataCenter dataCenter, double load) {
        double totalLoad = dataCenter.getListServer()
                .stream()
                .mapToDouble(Server::getLoad)
                .sum();
        System.out.println(totalLoad);
        for (int i = 0; i < dataCenter.getListServer().size(); i++) {
            double loadMax = dataCenter.getListServer().get(i).getMaxLoad();
            if (totalLoad >= loadMax) {
                dataCenter.getListServer().get(i).setLoad(loadMax);
                totalLoad = totalLoad - loadMax;
            } else {
                dataCenter.getListServer().get(i).setLoad(totalLoad);
                totalLoad = ZERO_LOAD;
            }
        }
    }
}
