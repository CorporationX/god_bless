package faang.school.godbless.java.sql.datacenter;

import java.util.Comparator;
import java.util.List;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();
        servers.sort(new Comparator<Server>() {

            @Override
            public int compare(Server s1, Server s2) {
//                System.out.printf("Double.compare(%.2f, %.2f) = %d %n", s1.getLoad(), s2.getLoad(), Double.compare(s1.getLoad(), s2.getLoad()));
                return Double.compare(s1.getLoad(), s2.getLoad());
            }
        });
    }
}
