package school.faang.datacenter.optimization;

import school.faang.datacenter.domain.DataCenter;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
public interface OptimizationStrategy {
    void optimize(DataCenter dataCenter);
}
