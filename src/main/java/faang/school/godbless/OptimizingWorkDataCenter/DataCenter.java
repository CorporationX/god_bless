package faang.school.godbless.OptimizingWorkDataCenter;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class DataCenter {
    @Getter
    private static Set<Server> serverSet = new HashSet<>();
}
