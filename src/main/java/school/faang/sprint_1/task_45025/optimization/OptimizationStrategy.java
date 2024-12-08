package school.faang.sprint_1.task_45025.optimization;

import school.faang.sprint_1.task_45025.data_center.DataCenter;
import school.faang.sprint_1.task_45025.exceptions.LoadOverflowException;

public interface OptimizationStrategy {
    void optimize(DataCenter dataCenter) throws LoadOverflowException;
}
