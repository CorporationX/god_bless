package faang.school.godbless.BJS2_19329;

import java.util.stream.DoubleStream;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
       double allServersLoad = dataCenter.getServersList().stream()
                .flatMapToDouble(server -> DoubleStream.of(server.getLoad()))
                .sum();
       double newServerLoad = allServersLoad / dataCenter.getServersList().size();
       for (Server server : dataCenter.getServersList()) {
           if(server.getLoad() <= newServerLoad) {
               server.setLoad(server.getLoad() + newServerLoad);
           }
           else {
           }
       }
    }
}
