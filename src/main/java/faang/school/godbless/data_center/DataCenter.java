package faang.school.godbless.data_center;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataCenter {
    OptimizationStrategy optimizationStrategy;
    private List<Server> serverList;
}