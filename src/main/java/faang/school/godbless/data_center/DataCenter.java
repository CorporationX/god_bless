package faang.school.godbless.data_center;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
public class DataCenter {
    private final OptimizationStrategy INITIAL_OPTIMIZATION_STRATEGY =
            OptimizationStrategy.LOAD_BALANCING_OPTIMIZATION_STRATEGY;

    OptimizationStrategy optimizationStrategy;
    private Set<Server> servers;
    private Set<Integer> resourceRequests;

    public DataCenter() {
        this.optimizationStrategy = INITIAL_OPTIMIZATION_STRATEGY;
        this.servers = new TreeSet<>(this.optimizationStrategy.getCompareStrategy());
        this.resourceRequests = new HashSet<>();
    }
}