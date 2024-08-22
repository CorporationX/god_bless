package faang.school.godbless.data.center;

import faang.school.godbless.data.center.optimization.strategy.LoadBalancingOptimizationStrategy;
import faang.school.godbless.data.center.service.DataCenterService;

public class Main {

    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        dataCenter.addServer(new Server(100));
        dataCenter.addServer(new Server(150));
        dataCenter.addServer(new Server(70));

        DataCenterService dataCenterService = new DataCenterService(dataCenter, new LoadBalancingOptimizationStrategy());

        OptimizationScheduler scheduler = new OptimizationScheduler(dataCenterService);
        scheduler.startOptimizationRoutine();

    }
}
