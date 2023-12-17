package faang.school.godbless.OptimizingWorkDataCenter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    @Getter
    private final List<Server> serverSet = new ArrayList<>();
}
