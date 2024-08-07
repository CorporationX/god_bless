package faang.school.godbless.BJS2_19415.OptimizationStrategy;

import faang.school.godbless.BJS2_19415.DataCenter;
import faang.school.godbless.BJS2_19415.Server;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        //данный алгоритм балансировки рассчитывает нагрузку на все сервера, рассчитывает общее количество
        //серверов, расчитывает среднее значение, и устанавливает это значение на каждый сервер
        double totalLoad = 0.0;
        for (Server server : dataCenter.getCluster()) {
            totalLoad += server.getLoad();
        }

        double avgLoad = totalLoad / dataCenter.getServersQuantity();
        for (Server server : dataCenter.getCluster()) {
            server.setLoad(avgLoad);
        }
    }
}
